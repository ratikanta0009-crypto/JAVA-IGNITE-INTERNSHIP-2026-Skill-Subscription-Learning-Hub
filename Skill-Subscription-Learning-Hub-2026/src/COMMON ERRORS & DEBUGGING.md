1. Whitelabel Error Page / 404

Problem: Page not opening

Fix:

Check URL in browser
Check controller mapping (@GetMapping)
Make sure controller class has @Controller


2. JSP not found

Problem: Cannot find JSP page

Fix:

JSP must be inside WEB-INF/views/
Return name correctly:
return "login" ❌ NOT login.jsp


3. NullPointerException

Problem: App crashes with null error

Fix:

Check if data is null before using it
Make sure service is properly injected
Check database data exists


4. Form data not coming to controller

Problem: Values are null

Fix:

Check name="" in input fields
Use @ModelAttribute or @RequestParam


5. POST not working (405 error)

Problem: Method not allowed

Fix:

Form method must match controller:
form → post
controller → @PostMapping


6. Data not showing in JSP

Problem: Page loads but empty

Fix:

Check model.addAttribute("key", value)
Check same key in JSP ${key}


7. Controller not working

Problem: URL not hitting controller

Fix:

Check @Controller
Check correct package
Check correct URL mapping


8. Autowired warning (yellow line)

Problem: IDE warning

Fix:

Use constructor injection instead of @Autowired


9. Login not working

Problem: Always fails login

Fix:

Use .equals() for password check
Check email exists in DB


10. Project not running

Problem: Spring Boot fails to start

Fix:

Check port conflict (8080)
Check console error
Restart Eclipse / server
SIMPLE DEBUG RULE
Check URL
Check controller
Check service
Check JSP