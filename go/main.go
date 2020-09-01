package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/goThing", someHandler)
	err := http.ListenAndServe(":8082", nil)
	if err != nil {
		log.Fatal("Failed to listen on port 8082...")
	}
}

func someHandler(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprint(writer, request.Header.Get("X-B3-Traceid"))
}
