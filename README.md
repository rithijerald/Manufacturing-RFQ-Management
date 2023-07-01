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
  flowchart LR;
      A[Admin]--User sign-in-->B[Authentication Server];
      B--User authenticated, JWT Created and returned to user-->A;
      A--User passes JWT when making API calls-->C[Application Server];
      C--Application verifies and processes API call-->A
      

```

**Supplier Microservice** <br/>
&nbsp;&nbsp;&nbsp;&nbsp; > Add suppliers and supplier parts. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Edit the details of the supplier and supplier parts. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Update the feedback of the supplier based on the parameters they supply. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Get all the supplier and supplier part details.<br />
<br />
<br />

```mermaid
   flowchart LR;
	A[Authorization]--Authorized user-->B[Admin];
	B--Add-->C[Add Supplier];
	C--Store supplier and part obj-->D[Supplier];
	B--partid-->E[Get supplier of part];
	E--partid-->D;
	D--get-->E;
	E--getid-->B;
	B--supplier obj-->F[Edit supplier];
	F--store-->D;
	D--get all-->G[Get All Supplier];
	G--get all-->B;
	B--update-->H[Update Feedback];
	H--store-->D;
```

**Plant Microservice** <br/>
&nbsp;&nbsp;&nbsp;&nbsp; > View stock in hand of a given part as of current date. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > View reorder point of any part as of current date. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Update the Min Quantity/ Max Quantity of the part based on assembly demands of the plant. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Min Quantity - If a stock reduces to this number a reorder is essential.<br />
&nbsp;&nbsp;&nbsp;&nbsp; > Max Quantity - The largest numbers to meet the demand.<br />
<br />
<br />

```mermaid
	flowchart LR;
		A[Authorization]--authorized user-->B[Admin];
		B--update-->C[Update Min Max rules];
		C--store-->D[Plant];
		D--get-->E[View stock in hands];
		E--get-->B;
		D--get-->F[View Reorder Parts];
		F--get-->B;
```

**RFQ Microservice** <br/>
&nbsp;&nbsp;&nbsp;&nbsp; >RFQ of a plant must be calculated based on the response from plant microservice on the parts that needs reorder. <br />
&nbsp;&nbsp;&nbsp;&nbsp; > Potential vendors have to be returned by reaching the supplier service who has good feedback to supply the given part based on the feedback rating. <br />

<br />
<br />

```mermaid
	flowchart LR;
		A[Authorization]--Validate-->B[Admin];
		B--rfq id-->C[Get Potential Vendors Of RFQ];
		C--supplier obj-->B;
		B--plant id-->D[Get RFQ of Plant];
		D--rfq obj-->B;
		C--rfq id-->E[RFQ];
		E--part id-->C;
		C--part id-->F[Get supplier of part id];
		F--supplier obj-->C;
		F--part id-->G[Supplier];
		G--supplier obj-->F;
		D--view-->H[View Reorder Parts];
		H--reorder obj-->D;
		H--View-->I[Plant];
		I--reorder obj-->H;
```
