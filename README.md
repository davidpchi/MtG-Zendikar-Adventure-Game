Zen Game Engine
===========================
##About##
This project started from making a platformer based on the Zendikar set of Magic: the Gathering. Although that project is still in process, developing a game engine to support the game has grown into a project of its own. So in the meantime, some documentation on how you can use the Zen Game Engine to make any game. 

##Features##
* Cycle through GamePanels in a MainFrame to allow for multiple levels, scenes, menus, etc
* Modular GameObject class is easily extendable and can be customized for various games
* Support for UI through UIObjects. Already implemented examples include buttons, menus, healthbars, etc
* Rudimentary particle generator allows for simple effects
* Basic 2d physics system implemented

##Documentation##
**Main Classes**
* MainFrame- The main frame that contains a GamePanel. You can cycle through GamePanels (similar to scenes or rooms)
* GamePanel- Represents a scene in which GameObjects and GameUI will live and be able to interacted with
* GameObject- Represents an object in worldspace that can be interacted with
* UIObject- Represents an object that exists for UI and exists in the camera space.
