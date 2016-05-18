load "ruby/person.rb"
u1 = Person.new("Ta Van Lu", 18);
serialized_object = Marshal::dump(u1)
Marshal::load(serialized_object)

#serialize
begintime = Time.now.getutc
100_000.times do
   Marshal::dump(u1)
end
endtime = Time.now.getutc
serialized_time = (endtime - begintime) *1000



#desearialize
begintime = Time.now.getutc
100_000.times do
   Marshal::load(serialized_object)
end
endtime = Time.now.getutc
deserialized_time = (endtime - begintime) *1000

puts "Byte Size:\t#{serialized_object.size}"
puts "Serialized Time:\t#{serialized_time}\nDeserialized Time:\t#{deserialized_time}"
