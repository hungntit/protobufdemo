var fs = require("fs")
var protos = require('./myproto_libs.js');
var obj = new Person()
obj.setName("Ta Van Lu");
obj.setOld(18);

var buf=null;
try {
     buf = obj.serializeBinary(obj) // you get Buffer here, send it via socket.write, etc.
     console.log("Object:\n\tName:\t"+ obj.getName()+"\n\tOld:\t"+ obj.getOld());
     console.log("Writing object to /tmp/nodejs_person.txt");
     fs.writeFile('/tmp/nodejs_person.txt', buf, function (err) {
      if (err) return console.log(err);

     });
     fs.readFile("/tmp/nodejs_person.txt", function (err, data) {
       var obj2 = new protos.Person();
       obj2.deserializeBinary(data)
       console.log("Reading object from /tmp/nodejs_person.txt");
       console.log("Object:\n\tName:\t"+ obj2.getName()+"\n\tOld:\t"+ obj2.getOld());
    });


} catch (e) {
    // will throw if MySchema does not exist
}
/*
setTimeout(function(){

  console.log("------------LOADTEST JSON------------------")
  var json_str = JSON.stringify(obj);
  JSON.parse(json_str);
  var json_t1 = new Date().getTime();
  for(var i= 0;i< 100000;i++){
    JSON.stringify(obj);
  }
  var json_t2 = new Date().getTime();
  for(var i= 0;i< 100000;i++){
    JSON.parse(json_str);
  }
  var json_t3 = new Date().getTime();
  var json_serialized_time = json_t2 - json_t1;
  var json_deserialized_time = json_t3 - json_t2
  console.log("Byte Size:\t"+json_str.length);
  console.log("Serialized Time:\t"+ json_serialized_time+ "\nDeserialized Time:\t"+json_deserialized_time)

  console.log("------------LOADTEST PROTOC------------------")

  var protoc_t1 = new Date().getTime();
  for(var i= 0;i< 100000;i++){
    pb.serialize(obj, "Person")
  }
  var protoc_t2 = new Date().getTime();
  for(var i= 0;i< 100000;i++){
    pb.parse(buf, "Person")
  }
  var protoc_t3 = new Date().getTime();
  var protoc_serialized_time = protoc_t2 - protoc_t1;
  var protoc_deserialized_time = protoc_t3 - protoc_t2
  console.log("Byte Size:\t"+buf.length);
  console.log("Serialized Time:\t"+ protoc_serialized_time+ "\nDeserialized Time:\t"+protoc_deserialized_time)

}, 1000);
*/
