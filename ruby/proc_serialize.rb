load "ruby/person.pb.rb"


# Just so we don't get spammed when testing

u1 = Person.new({:name =>"Ta Van Lu", :old => 18});
serialized_object = Person.encode(u1)
Person.decode(serialized_object)


#test write, read object
puts "Object:\n\tName:\t#{u1.name}\n\tOld:\t#{u1.old}"
puts "Writing object to file /tmp/ruby_person.txt"
File.open("/tmp/ruby_person.txt", 'wb' ) do |output|
  serialized_object.bytes.each { |b| output.print b.chr }
end

puts "---------------------------------------------------------------------------"

#serialize
begintime = Time.now.getutc
100_000.times do
   Person.encode(u1)
end
endtime = Time.now.getutc
serialized_time = (endtime - begintime) *1000



#desearialize
begintime = Time.now.getutc
100_000.times do
  Person.decode(serialized_object)
end
endtime = Time.now.getutc
deserialized_time = (endtime - begintime) *1000

puts "Byte Size:\t#{serialized_object.bytesize}"
puts "Serializing Time:\t#{serialized_time}\nDeserializing Time:\t#{deserialized_time}"
