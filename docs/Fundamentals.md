# Fundamentals

Reference: [Linux Foundation Edx Course](https://learning.edx.org/course/course-v1:LinuxFoundationX+LFS141x+3T2019/home)

### What is GraphQL

- Is a new API standard which provides more efficient, powerful and flexible alternative to REST APIs
- Enables *declarative data fetching*, where the client specifies exactly what data it requires
- Exposes only one endpoint over which the client can request for specific data from the server making managing multiple clients more efficient
- GraphQL is a **Query Language for the API**


### GraphQL is the better REST

1. REST has strong contract about the API and its response. While GraphQL is more client
oriented where clients are free to request data depending on requirement without changing
of contract/design/implementation

2. GraphQL is more network efficient as the client/device with less network bandwidth can
request data as per requirement

3. Requirement changes are tough to accomodate into the REST style APIs. With REST style APIs
it is difficult to accomodate new fields which breaks existing client contracts. But with GraphQL
it is more easy to accomodate new data fields since it does not affect any existing clients

4. Analysis Service can be run on the request-response and can be determinesd if any field is
okay to be deprecated as not client is using it

5. The most important benefit of GraphQL is the strong **Typing Typing System** defined
using the **Schema Definition Language**. Since the contract is predefined with use of SDL 
and the types defined, development of frontend and backend can be independent.

## Core Concepts

GraphQL has its own type system to define the Schema of an API.
The syntax of the schema is defined as **Schema Definition Language**

```graphql
type Person {
  name: String!         # Exclaim means , this field cannot be null
  age: Int
}

type Post {
  title: String!

```
In the above example, _Person_ and _Post_ is a type defined in the schema.
It is also possible to define a _Relation_ between types which is called **Relationship**.

```graphql
# Adding a relation that one Person is the author of multiple posts
type Person {
  name: String!
  age: Int!
  posts: [Post!]!       # List of Posts, Post cannot be null nor can be the list
}

type Post {
  title: String!
}

```


- Query is a type which is the request sent to the server with the requested data information
- Mutation is a type which allows clients to modify data on the server
  - Creating dew data
  - Updating existing data
  - Deleting existing data
- Subscription for Realtime Updates/Events

### GraphQL Schema

- defines capabilities of the API by specifying how a client can fetch and update data
- represents a contract between client aand server
- collection of GraphQL Types

Root Types:

```graphql
type Query {

}

type Mutation {

}

type Subscription {

}
```

**Example of Schema and corresponding Request**

```graphql
# Query is one of the root type for querying dataa
type Query {
  allPerson(size: Int, page: Int): [Person!]!
}


# Mutation is one of the root type to mutate the data
type Mutation {
  createPerson(name: String!, age: Int!): Person!
}

# Another root type is subscription
type Subscription {
  newPerson: Person!
}

type Person {
  id: ID!
  name: String!
  age: Int!
  posts: [Post!]!
}

type Post {
  title: String!
}
```

**Query to get a list of 100 people of 2nd page, requested data: name and title of 
all posts by the users**

```
{
  allPerson(size: 100, page: 2) {
    name
    posts {
      title
    }
  }
}

```

**Mutation to create a Person**
```
mutation {
  createPerson(name: "Bob", age: "43") {
    id
  }
}
```

**Request for a subscription**
```
subsscription {
  newPerson {
    name
    id
  }
}
```


