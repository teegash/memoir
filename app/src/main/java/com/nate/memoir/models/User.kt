package com.nate.memoir.models

class User{
    var email:String=""
    var pass:String=""
    var userid:String=""   // this is automatically generated, unique code

    // This part if its for registering yu can add features like gender etc

    constructor(email:String,pass:String,userid:String){
        this.email=email
        this.pass=pass
        this.userid=userid

    }
    constructor() // firebase requires this constructor, so we have to call here
}

// this will send data to authviewmodel