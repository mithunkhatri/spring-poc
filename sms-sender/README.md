Simple sms sender application built using Spring Boot and Twilio SDK.

Twilio Dependency:
```
<dependency>
  <groupId>com.twilio.sdk</groupId>
  <artifactId>twilio</artifactId>
  <version>7.41.1</version>
</dependency>
```

Postman Collection:
https://www.getpostman.com/collections/6ca52172cd763b06648b

curl to send sms : 

```
curl -X POST \
  http://localhost:8080/send/sms \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 82' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 74cf2849-36b1-4507-8633-4ca8ccfef1fb,810732a7-8e1b-4de7-800c-f67a0db14adb' \
  -H 'User-Agent: PostmanRuntime/7.15.2' \
  -H 'X_ACCOUNT_SID: <accountSid>' \
  -H 'X_AUTH_TOKEN: <authToken>' \
  -H 'cache-control: no-cache' \
  -d '{
	"from": "<from number>",
	"to" : "<to number>",
	"text" : "<sms body>"
}'
```

*NOTE* : All Headers and Request body parameters are mandatory
