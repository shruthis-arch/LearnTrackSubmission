Why you used ArrayList instead of array ?
ArrayList is used because the number of students, courses, and enrollments are dynamic and not known in advance.  Array has to be of a predefined size and as it is not known it cannot be used. In other words, arraylist allows dynamic resizing.

Where you used static members and why ?
Where you used inheritance and what you gained from it
ID generation belongs to the class, not an individual object.
Only one counter should exist for the entire application.
No need to create an object just to generate an ID.

Where you used inheritance and what you gained from it?
Inheritance allows code reuse, maintainable and is extensible as new users can be added easily in future.