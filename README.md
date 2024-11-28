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

<img width="484" alt="image" src="https://github.com/user-attachments/assets/c71d35ec-3b79-439f-8913-91be1f20db28"> 

<br></br>
<img width="400" alt="image" src="https://github.com/user-attachments/assets/61e16eba-fe7a-4c56-9dc0-0fb8a34f2bef">

<br></br>
<img width="400" alt="image" src="https://github.com/user-attachments/assets/4df9745a-1acc-40b5-bc03-e6d158f0beb0">

2. To save the parents associated with the child, we MUST have CASCADE TYPE PERSIST on ONE TO MANY

   <img width="479" alt="image" src="https://github.com/user-attachments/assets/1dff09cc-eaf2-4fa7-8dd9-86bc3dfa232b">

   <br></br>
<img width="300" height="470" alt="image" src="https://github.com/user-attachments/assets/04fc1bb6-d205-4a03-ba45-aa7b876991c2">


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

<br>If we don't specify a <b>@JoinColumn</b> attribute on the <b>parent side</b>, and we specify the <b>mappedBy</b> attribute on the <b>child side</b>, we would have the following result table</br>

<img width="643" alt="image" src="https://github.com/user-attachments/assets/f644f2e7-9abd-4b6b-b921-1d5adccee32e">


<br></br>
<img width="643" alt="image" src="https://github.com/user-attachments/assets/5d1a6da6-4444-435f-968a-fc4525372049">

<br></br>

<img width="631" alt="image" src="https://github.com/user-attachments/assets/bd09398f-4197-4a23-bbd4-02ab191a7f1a">

<h1>CONCLUSION</h1>

<h2> UNI-DIRECTIONAL One-to-Many and Many-to-One Relationships </h2>

<h3>STUDENT TABLE</h3>

<img width="643" alt="image" src="https://github.com/user-attachments/assets/eaccd08e-d572-41b8-bae9-815241bf95d0">

<h3>GUIDE TABLE</h3>

<img width="300" alt="image" src="https://github.com/user-attachments/assets/abb5b3d5-032c-47af-a247-abe7ee50d9fc">

<h3>JOIN TABLE</h3>

<img width="300" alt="image" src="https://github.com/user-attachments/assets/529f5a1e-fc44-4642-8dea-881371a3891e">


<br></br>

<h2> BI-DIRECTIONAL One-to-Many and Many-to-One Relationships </h2>

<h3>STUDENT TABLE</h3>

<img width="377" alt="image" src="https://github.com/user-attachments/assets/a2e923bd-f03c-4bba-9ee0-9b186e95806a">


<h3>GUIDE TABLE</h3>

<img width="200" alt="image" src="https://github.com/user-attachments/assets/a994b848-7297-4051-9c7a-64c40b84f2bc">

<br></br>
<h1>PROCEDURES</h1>

<br></br>
<h3>CREATE A PROCEDURE IN MYSQL WORKBENCH</h3>
<img width="500" alt="image" src="https://github.com/user-attachments/assets/4d19809b-8516-455f-8310-c67d9564ef36">

<br></br>
Use <b>Native Query</b> to call the procedure in the Repository

<img width="600" alt="image" src="https://github.com/user-attachments/assets/f1f4ba12-2cd3-4b30-8a54-6cd097bf28fd">

<br></br>
Use <b>@Procedure</b> annotation in the Repository

<img width="500" alt="image" src="https://github.com/user-attachments/assets/f94e9ad3-e7c2-478b-a9b0-15daf231f825">


<br></br>
Create a record in DTO level to return just the needed information

<img width="491" alt="image" src="https://github.com/user-attachments/assets/edb0ce49-042a-47aa-8b5d-da4d81311db2">

<br></br>
Map the result in the Service layer

<img width="791" alt="image" src="https://github.com/user-attachments/assets/83668fd7-9d2d-4304-94d7-6ed5c5ae26db">

<br></br>
Call the request for the procedure

<img width="691" alt="image" src="https://github.com/user-attachments/assets/cf76ae50-bcf3-4d93-810e-54ebb846097d">

<br></br>
<h1>PROJECTION</h1>

<br></br>
Create a record in DTO 

<img width="491" alt="image" src="https://github.com/user-attachments/assets/14d87c67-0493-4823-9fbc-994dcc984562">

<br></br>
Create a method in Repository that will return the projection

<img width="591" alt="image" src="https://github.com/user-attachments/assets/d94c46f6-df54-4975-a6f9-783c1d7610cd">

<br></br>
Make the call to the request

<img width="591" alt="image" src="https://github.com/user-attachments/assets/0a38b120-8cd5-4b82-ac7b-e59bfdf00210">

<br></br>
<h1>INHERITANCE</h1>
<br></br>
<b>SINGLE TABLE STRATEGY</b> a single Animal table is created that has types of animals that are being inserted. We have Cat and Dog entities, dto, repositories, service and controller layer, however a single table is created
<br></br>
<img width="491" alt="image" src="https://github.com/user-attachments/assets/e5ba1e76-6cf5-4725-b06e-ddcdfef3fa55">

<br></br>

<img width="491" alt="image" src="https://github.com/user-attachments/assets/24a3e03f-a149-4b1d-afde-f32e7aca25f8">

<h2></h2>
<b>JOINED TABLE STRATEGY</b> each class is mapped to its own table. Tables are linked using <b>FOREIGN KEY</b>, and the base table has a discriminator column. 
The two child tables: CAT and DOG have no link between them, so we can not use a <b>JOIN</b> between them, as there is no relationship between them. 
Also, having the an attribute in the parent class means we can not have the same attribute in the children classes. 
<br></br>
The GenerationType for the id must be SEQUENCE, with IDENTITY there is no guarantee that the id will be unique.
<br></br>
<img width="391" alt="image" src="https://github.com/user-attachments/assets/28ad55d5-937e-4538-a749-473d9f199ca4">
<br></br>

<b>ANIMAL TABLE</b>

<img width="191" alt="image" src="https://github.com/user-attachments/assets/794a1387-cfdf-4ed7-b049-f4a4a78f8189">

<br></br>
<b>DOG and CAT TABLE</b>

<img width="291" alt="image" src="https://github.com/user-attachments/assets/0d64363e-eb73-429d-b500-c4056e420884">

<h2></h2>





