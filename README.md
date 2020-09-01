# Spring Sleuth Example

This application showcases a simple example of Spring Cloud Sleuth's tracing capabilities.
It focuses strictly on traceability for HTTP requests however it does posses the capability in a very similar out of the box fashion for Kafka and RabbitMQ.

# How To Run

Simply execute the script file in the `docker` folder (`run-sleuth-example.sh`) which will build and run the docker containers.
The containers simply contain an instance of the spring boot app running on port 8080 and 8081. 

To showcase Sleuth's capabilities simply hit `http://localhost:8080/something` via browser, Postman, etc.
The response of the previous url will be the trace ids that Sleuth uses in each container running.

As we would expect they should be the same for each container since this represents our microservice ecosystem. This shows how we can trace messages at a larger scale.

# Other Notes

Notice that with Slf4j we get Sleuth integration for free as well. 
When we log a new message the Sleuth information is prepended to the message in the following fashion: `[APP_NAME, TRACE_ID, SPAN_ID, EXPORTABLE] THE_REST_OF_THE_LOG_MESSAGE_HERE...`

As mentioned previously, Spring Sleuth also has out of the box integration for Kafka and RabbitMQ. Sleuth should automatically inject tracing headers onto messages when they are sent.
