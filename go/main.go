package main

import (
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/goThing", someHandler)
	http.ListenAndServe(":8082", nil)
}

func someHandler(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprint(writer, request.Header.Get("X-B3-Traceid"))
}
