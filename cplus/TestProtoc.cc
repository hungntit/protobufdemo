#include <iostream>
#include <fstream>
#include <string>
#include "person.pb.h"
using namespace std;

int main(int argc, char* argv[]) {
  Person * person = new Person();
  person->set_name("Ta Van Lu");
  person->set_old(18);
  cout << "Object:\n\tName:\t" << person->name() << "\n\tOld:\t"<< person->old() << endl;
  //write protobuf object to file
  cout << "Writing object to /tmp/cplus_person.txt" << endl;

  fstream output("/tmp/cplus_person.txt", ios::out | ios::trunc | ios::binary);
  person->SerializeToOstream(&output);
  output.close();
  // read protobuf object from file
  cout << "Reading object from /tmp/cplus_person.txt" << endl;
  fstream input("/tmp/cplus_person.txt", ios::in | ios::binary);
  person->ParseFromIstream(&input);
  input.close();
  cout << "Object:\n\tName:\t" << person->name() << "\n\tOld:\t"<< person->old()  << endl ;
  // Optional:  Delete all global objects allocated by libprotobuf.
 google::protobuf::ShutdownProtobufLibrary();
 return 0;

}
