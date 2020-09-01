FROM golang:alpine
WORKDIR /app
ENV SRC_DIR=.
ADD . $SRC_DIR
RUN cd $SRC_DIR; go build -o goapp;
ENTRYPOINT ["./goapp"]