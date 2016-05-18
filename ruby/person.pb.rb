require 'google/protobuf'
#generate
pool = Google::Protobuf::DescriptorPool.new
pool.build do
    add_message "Person" do
      optional :name, :string, 1
      optional :old, :uint32, 2
    end
end
Person = pool.lookup("Person").msgclass

#end generate
