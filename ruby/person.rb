require "json"
class Person
  def initialize(name,old)
    @name = name
    @old = old
  end
  def to_s
    "In Person:\n   #{@name}, #{@old}\n"
  end
  def to_json(*a)
    {
      "json_class"   => self.class.name,
      "data"         => {"name" => @name, "old" => @old }
    }.to_json(*a)
  end

  def self.json_create(o)
    new(o["data"]["name"], o["data"]["old"])
  end
end
