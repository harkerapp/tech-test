
# Prerequisites

Java 21: 

- Direct download: [https://www.oracle.com/uk/java/technologies/downloads/#java21](https://www.oracle.com/uk/java/technologies/downloads/#java21)
- Or use a package manager to install openjdk such as:
    - Mac: brew
    - Linux/WSL: [apt/yum/dnf etc…]
    - Windows: choco

Maven:

- Mac (Using homebrew): `brew install maven`
- Linux/WSL: `sudo [apt/dnf/pacman] install maven` (choose whatever package manager you have)
- Windows (Using chocolatey): `choco install maven`

Node.js 22.13+ or 24 LTS (it should install npm too) [https://nodejs.org/en/download/package-manager](https://nodejs.org/en/download/package-manager)

PNPM 10+ [https://pnpm.io/installation](https://pnpm.io/installation)

# Helpful Documentation/Tips

- Install some API testing application such as Postman or Insomnia, this will help you with testing your backend code.
- RESTful API [https://aws.amazon.com/what-is/restful-api/#seo-faq-pairs#what-restful-api-client-contain](https://aws.amazon.com/what-is/restful-api/#seo-faq-pairs#what-restful-api-client-contain)
- Methods that can be used on the PersonRepository:  [https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)
- Tailwind CSS docs: [https://tailwindcss.com/docs/](https://tailwindcss.com/docs/) (installation and basic setup has already been done).
- Extensions/intellisense in your IDE for Java, SpringBoot, TypeScript and Tailwind CSS.

# How to run the application

- After install dependencies, clone and run `pnpm install` once. If you do choose to add any other dependencies then run this again.
- To compile the backend & frontend code `pnpm run build`
    - To specify one use `build:backend` or `build:frontend` instead
- To start both servers: `pnpm run start`
    - To specify one use `run:backend` or `run:frontend` instead

- By default the backend server should run on [http://localhost:8080](http://localhost:8080)
- By default the frontend server should run on [http://localhost:3000](http://localhost:3000)

# Tasks

Some tasks are marked with comments

### Backend:

Note: After changes you will need to close the server with Ctrl+C in the terminal and re-run the build and start commands.


> 💡 Usually you wouldn’t manually set an ID, but for simplicity this task uses a client-supplied ID.


You are building a small person directory. The person fields, GET endpoints and basic POST/PUT save logic are provided. The starter code saves records, but does not yet enforce the rules below. Your task is to correct its behaviour. Keep the existing ID attribute and endpoint paths.

1. **Validate and normalise input.** For both POST and PUT, `fullName` must contain at least one non-whitespace character. Return HTTP 400 for a missing, null or blank name without changing the database. Remove leading and trailing whitespace from a valid name before saving it. Choose where to put this logic and how to share it between create and update. For example, `"  Sam Taylor  "` should be stored as `"Sam Taylor"`. `email` is optional; email-format validation is not required. Feel free to add any extra validation or normalisation that you see fit. 

2. **Make create safe to repeat.** POST currently saves directly, which can overwrite a person with the same ID. Change it so a duplicate ID cannot change the existing record. Implement appropriate handling. A new ID should still create and return a person. Decide how to check for an existing record using the repository.

3. **Update only an existing person.** PUT takes the ID from the request body. Update the person with that ID and return the saved record. If the ID does not exist, return an appropraite status code without creating a record. Update requests include `fullName`, but may omit `email`: choose whether an omitted/null email clears the stored email or keeps its previous value. Both policies are acceptable.

In the interview, we will use your implementation as the starting point for discussion.

### Frontend:

Note: This frontend has fast refresh so any saved changes are reflected instantly on the web page, no need for rebuilding.

1. In PersonForm.tsx add `fullName` and optional `email` to the personSchema, populate postPath & putPath with `/people`, and add input fields for both attributes to the form.
2. The backend name validation satisfies the field-validation requirement. You may also add frontend validation, but it is not required.
3. In PersonForm.tsx Add a dynamic success message depending on whether the user has created or updated a person.
4. In PersonView.tsx use the GET endpoint to fetch and return a specific Person from their id when the View button is pressed. Then display the response below the View button.
5. In App.tsx, PersonForm.tsx and PersonView.tsx, there is already some basic styling but it is incomplete and unprofessional, your task is to add more styling using tailwindcss (e.g. spacing, alignment, shapes and colours). You can use tailwind’s default colours or add some of your own in the tailwind.config.js file. There is a lot of freedom here to show off frontend skills, you can completely redesign the layout, and change anything about the styling you want as long as all previous functionality is possible.
