#### What are Sockets and Threads?
A thread is a sequence of instructions that run independently of the program and of any other threads.
A socket is a software endpoint that establishes bidirectional communication between a server program and one or more client programs.

The socket associates the server program with a specific hardware port on the machine where it runs so any client program anywhere in the network with a socket associated with that same port can communicate with the server program.

A server program typically provides resources to a network of client programs. Client programs send requests to the server program, and the server program responds to the request.

One way to handle requests from more than one client is to make the server program multi-threaded. A multi-threaded server creates a thread for each communication it accepts from a client. A thread is a sequence of instructions that run independently of the program and of any other threads.

Using threads, a multi-threaded server program can accept a connection from a client, start a thread for that communication, and continue listening for requests from other clients.

#### OOP
- Corresponding methods close to object
- Data represents real life objects (most of the times)
- Classes loosely coupled
- Should be kept in a valid state

#### Repositories
Provides interface for storing and retrieving data from a datasource (CRUD operations)
data source, such as a database or file system
Repositories can be used to improve the modularity and maintainability of an application by separating the code that
interacts with the data source from the rest of the application code.

In Java, a repository is a design pattern used to provide a consistent interface for storing and retrieving data from a
data source, such as a database or file system. The repository pattern abstracts away the details of data storage and
retrieval, allowing other parts of the application to interact with the data source in a consistent and predictable way.

In a typical Java application, a repository is implemented as a separate class or set of classes that are responsible
for managing the interaction between the application and the data source. The repository class exposes methods that
allow other parts of the application to perform common CRUD (Create, Read, Update, Delete) operations on the data.

Repositories can be used to improve the modularity and maintainability of an application by separating the code that
interacts with the data source from the rest of the application code. By doing this, it becomes easier to change the
underlying data storage technology or to switch to a different data source without having to modify the rest of the
application code.

#### Model-View-Controller
Model: application's data and logic
View: Displaying Data to user
Controller: Updates view, process input, triggers update - handling user input and interaction (in between those 2)

- Separation of concerns
- Reusability
- Testability

### REST:

REST stands for Representational State Transfer
Each resource is represented as a state
REST API is a way of creating web services that use HTTP requests to retrieve and send data
Resolves around ressources that are uniquely identified by a Uniform Resource Identifier (URI)
RESTful web services allow the client to interact with the server using standard HTTP requests and responses


Highly Scalable

The concept of REST revolves around resources, which are uniquely identified by a Uniform Resource Identifier (URI).
A resource can be anything from a web page to a collection of data, such as customer data in a database.
Each resource is represented as a state that can be transferred between the client and the server.
In REST, a client can request a representation of a resource's current state, modify the state by sending data to the
server, and delete the resource entirely.

The key principles of REST include stateless communication, where each request from the client to the server contains
all necessary information, and the server does not store any client context.
This makes RESTful services highly scalable, as they can be load-balanced across multiple servers without any need for
server affinity. Another principle is the use of standard HTTP methods for different actions, such as GET for retrieving
data, POST for creating data, PUT for updating data, and DELETE for deleting data.

Overall, REST APIs provide a standardized and flexible way to create web services that can be easily consumed by a
variety of clients, including web browsers, mobile apps, and other servers.

#### Project Structure (MVC)

controller: contains classes that handle HTTP requests and responses
model: contains classes that represent domain objects
repository: contains classes that manage database interactions
service: contains classes that provide business logic and orchestrate interactions between the controller and repository
util: contains utility classes that support other components
The src/main/resources directory contains configuration files for the application. In this example, the
application.properties file might include settings such as database connection information.

Overall, this project structure follows the Model-View-Controller (MVC) pattern, with the model, view (represented by
the web resources), and controller components separated into different packages. The repository and service components
provide an additional layer of separation between the data access and business logic components. The util package
provides common utility classes that can be used throughout the application.

#### Acceptance tests vs. System tests
Acceptance tests are focused on validating the system against stakeholder requirements and expectations
System tests are focused on ensuring that the system meets all of its functional and non-functional requirements.
The goal of validation testing is to ensure that the software product is fit for its intended use and meets the needs of its users.

#### Fork / Join / Thread
A fork is a new process that is created to run in parallel with the main process.
Allowing multiple tasks to be executed simultaneously.
Forks are often used to take advantage of multiple cores or processors on a computer

The Fork/Join Framework is particularly useful for parallelizing recursive algorithms, where a large problem is broken down into smaller sub-problems, each of which can be solved independently.

The main concept in the Fork/Join Framework is the ForkJoinPool. This pool manages a group of worker threads that can execute tasks in parallel. The tasks are submitted to the pool using the fork() method, which creates a new fork to execute the task. The fork then runs in parallel with the main thread, until it completes and returns its result.

The Fork/Join Framework also provides a way to synchronize the results of the sub-tasks. This is done using the join() method, which waits for a fork to complete and returns its result. The framework also provides a way to merge the results of multiple sub-tasks, using the fork-join pattern.

#### HTTP Helper Framework

#### Factory methods

In object-oriented programming, a factory method is a method that creates and returns objects of a certain class. The
factory method pattern is a creational pattern that uses factory methods to create objects without specifying the exact
class of object that will be created. The pattern provides a way to encapsulate the object creation logic in a separate
method or class, making it easier to change or extend the way objects are created.

The factory method pattern is often used in situations where a client needs to create an object, but doesn't know which
concrete class to instantiate. The factory method allows the client to delegate the responsibility of object creation to
a separate method or class, which can determine the appropriate class to use based on some criteria or configuration.
This can help to reduce coupling between classes and improve the flexibility and maintainability of a system.
