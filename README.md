# Manufacturing-RFQ-Management
<br />
<br />

**Authorization Module** <br/>
&nbsp;&nbsp;&nbsp;&nbsp; > To create a login page for authentication. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Generate JSON Web Token. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Service to Service Communication has to happen using JWT.<br />
&nbsp;&nbsp;&nbsp;&nbsp; > Pass End User Context across Microservices.<br />
&nbsp;&nbsp;&nbsp;&nbsp; > Token will expire after specific amount of time ( 15 minutes ).<br />
<br />
<br />



		

```mermaid
sequenceDiagram
Admin->>AuthorizationServer: User sign-in
AuthorizationServer-->>Admin: User authenticated, JWT Created and returned to user!
Admin->>ApplicationServer: User passes JWT when making API calls
ApplicationServer-->>Admin: Application verifies and processes API calls
```
