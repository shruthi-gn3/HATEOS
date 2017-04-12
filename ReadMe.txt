The project has a client resource and a server resource.
Run the project and this starts up the server. Now right click on the file AppealsClient in the source packages folder and run it. This starts the client which executes each of required scenarios.

The entry point to the appeals process is the creation of the appeal which can be done by a POST call to the URI http://localhost/HateosAppeals/webresources/appeal

This creates an appeal object and from here we have links to 3 different states i.e update, delete and process.
If the appeal is updated it goes abck to the created state.
If the appeal is deleted, updating or processing the appeal later results in a invalidexception.
If the appeal is processed it goes to a temporary pending state from where the professor can accept/reject the appeal request by providing feedback.

The client prints the output for each of the different scenarios as follows.
1. Happy case 
   Appeal Created -> Appeal Processed (accept/reject)

2. Abandoned Case 
   Appeal Created -> Appeal deleted

3. Forgotten Case
   Appeal Created -> Appeal Pending -> Follow up -> Appeal Processed

4. Bad Start
   Incorrect URI -> Appeal cannot be created

5. Bad ID
   Appeal Created -> Appeal Pending -> cannot follow up as the Id has been forgotten.

DAP and hypermedia format called application/vnd-cse564-appeals+xml has been created for the appeals process.