Pagination and Sorting

1. In the Repository a pagination method can accept others parameters, but it is mandatory to include one Pageable parameter

 <img width="461" alt="image" src="https://github.com/user-attachments/assets/43c9fbd2-f9e0-456d-bc22-f0f0646257ce">


<h1></h1>
2.Sorting will be done by the registration date first, and second after name and enrollment id


<img width="722" alt="image" src="https://github.com/user-attachments/assets/e32adbc4-87e7-432e-8a4d-422cd711e74a">


The result can be seen here: 
<img width="484" alt="image" src="https://github.com/user-attachments/assets/d2e093c2-994f-494a-a131-574e112efb8d">


<h1>ONE TO MANY</h1>

<b>SAVING A CHILD</b>
<br></br>
1. No CASCADE TYPE ON CHILD means when saving a child with the list of parents, the parents associated with it are not saved

<img width="404" alt="image" src="https://github.com/user-attachments/assets/26003d7d-dea5-438d-b0f4-4381c2b6535e">
<br></br>

![image](https://github.com/user-attachments/assets/c71d35ec-3b79-439f-8913-91be1f20db28) 

<br></br>
![image](https://github.com/user-attachments/assets/61e16eba-fe7a-4c56-9dc0-0fb8a34f2bef)

<br></br>
![image](https://github.com/user-attachments/assets/4df9745a-1acc-40b5-bc03-e6d158f0beb0)

2. To save the parents associated with the child, we MUST have CASCADE TYPE PERSIST on ONE TO MANY

   <img width="479" alt="image" src="https://github.com/user-attachments/assets/1dff09cc-eaf2-4fa7-8dd9-86bc3dfa232b">

   <br></br>
   ![image](https://github.com/user-attachments/assets/04fc1bb6-d205-4a03-ba45-aa7b876991c2)


  <br></br>
  <img width="224" alt="image" src="https://github.com/user-attachments/assets/a1b58d41-2200-46ed-b03c-4f1ef36c86f7">
  <br></br>
  <img width="431" alt="image" src="https://github.com/user-attachments/assets/ef0ed9c5-c883-4c60-8d72-075fcd26d55e">

<br></br>

<b>LOADING A CHILD</b>
<br></br>
 By default, <b>@OneToMany</b> associations are fecthed <b>LAZY</b>ly. We have to specify <b>EAGER</b> <b>FetchType</b>
 
<img width="643" alt="image" src="https://github.com/user-attachments/assets/3716500a-1beb-4f5c-ba56-02e7fbc94e95">
<br></br>
<img width="300" height="470" alt="image" src="https://github.com/user-attachments/assets/a3804b5d-3342-40bc-86c2-c325e3466a22">

<br></br>
When you <b>omit</b> the <b> mappedBy </b> attribute in the <b>@OneToMany</b> annotation in the Guide class, Hibernate will treat the relationship as <b>unidirectional</b>. This means that Hibernate will expect a <b>JOIN table</b> to manage the association between Guide and Student, rather than using a foreign key in the Student table.
<br><br>

<h2>Explanation: </h2>

<b>Without mappedBy: </b>

Hibernate will create a join table to manage the many-to-one relationship.

The studentList in the Guide class will be initialized, but it won't correctly map to the Student entity's guide field.

This could lead to Student entities not being loaded as expected when fetching a Guide.

<b>With mappedBy:</b>

The mappedBy attribute specifies that the studentList is mapped by the guide attribute in the Student entity.

This establishes a bidirectional relationship, where the Student entity maintains the foreign key and the Guide entity refers to it.

Hibernate will then correctly fetch the Set<Student> when you fetch a Guide.





 
<h1>MANY TO ONE</h1>




