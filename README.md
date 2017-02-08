
Game utilities
----------------

Author: Simone Mignami <simone.mig29@gmail.com>

Description:
Small library for game development support.

Feature summary:

- Coordinates
	- Extract bounding box from a set of points
	- Lengthdir_x/y: extract the x/y component of the vector made by length and direction
- Image scale
	- Sprite scale keeping aspect ratio
- Angles
	- Angle normalization
	- Point direction
- Snap to grid
- Normal random generation using gaussian distribution


### coordinates ###

**Lengthdir**

Suppose you have an helicopter with a gun, and that gun can rotate. When you hit the Fire key, where do you put the bullet? Of course, not at the center of the gun (usually the 0,0 coordinates...right? RIGHT?).
To put the bullet at the end of the gun you need just its length and direction and with the lengthdir_x/y you can get the (x,y) coordinates of the starting point.

** Point direction**

Given two points, returns the angle. It uses the standard trigonometric values, where the zero is right, 90° is up and 270° is bottom.


### Snap to grid ###

![Snap to grid in action](https://i0.wp.com/csanyk.com/rants/wp-content/uploads/2012/09/move_snap1.png?resize=292%2C163&ssl=1)

Computes coordinates to put the given object at the intersection of the grid or into the center of a cell.


### Gaussian generation ###

the random generation provides a "linear" distribution: each point in a line has the same probability to be "picked-up". 
Suppose you want an assault of enemies that spawn in a line, but at the center there is the greater probability to spawn, use a **gaussian distribution**.


License
--------

Feel free to use this small library. Please insert my name; also email me, I am curious about the use of my code ;-)
