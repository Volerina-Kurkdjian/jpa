Pagination and Sorting

1. In the Repository a pagination method can accept others parameters, but it is mandatory to include one Pageable parameter

 <img width="461" alt="image" src="https://github.com/user-attachments/assets/43c9fbd2-f9e0-456d-bc22-f0f0646257ce">


<h1></h1>
2.Sorting will be done by the registration date first, and second after name and enrollment id


<img width="722" alt="image" src="https://github.com/user-attachments/assets/e32adbc4-87e7-432e-8a4d-422cd711e74a">


The result can be seen here: 
<img width="484" alt="image" src="https://github.com/user-attachments/assets/d2e093c2-994f-494a-a131-574e112efb8d">


<h1>ONE TO MANY</h1>

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


<h1>MANY TO ONE</h1>




