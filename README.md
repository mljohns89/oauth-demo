#Spring Boot OAuth2 Demo

A Proof of Concept project that uses Spring Boot and OAuth2 to demonstrate the Authorization Code Grant Flow.


##Usage

###Overview
This Project has three components:
1. demo-auth-server
2. demo-client-ui
3. demo-resource-api

###demo-auth-server
This is our Authorization Server.  It has a couple of in memory users (user and admin).  It produces Access Tokens in the form of a JWT.
Their credentials:
1. user: pass
2. admin: adminpass

###demo-client-ui
This is our Web App.  It serves as the front end for our Authorization Code Grant Flow.  It uses OAuth2Sso to authenticate with our Authorization Server and gain an access token.

###demo-resource-api
This is our Resource Server (Protected Api).  This is the api we want to access with our access token.  Currently, the api only has one endpoint (/api/test) which prints a simple string.  But to access this endpoint, we need a valid access token.

###Flow
1. Start all three Spring Boot apps
2. Open a browser and go to "localhost:9999/ui"
3. You will be automatically redirected to the Auth Server to authenticate.
4. Enter **user** for the username and **pass** for the password. Click "Login".
5. You should be automatically redirected back to "localhost:9999/ui".
6. At this point you should be authenticated and see two buttons.  "Heartbeat" and "User Info".
7. Heartbeat is just a simple "heartbeat" response.  User Info, however, will respond with a valid Access Token from the Auth Server.
8. Copy this JWT and open Postman (alternatively you can do a cURL).
9. Here is a sample cURL request.  Note:  You'll have to replace the Bearer token with the JWT you just copied.

    curl -X GET \
  http://localhost:7000/api/test \
  -H 'Authorization: Bearer [REPLACE_WITH_ACCESS_TOKEN]'

10. You should see "Hello Test!" as the response.
11. To confirm that the endpoint is in fact protected, you can redo the above cURL without the Authorization Header.
12. You should see an unauthorized error in the response.


