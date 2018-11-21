![GitHub](https://img.shields.io/github/license/TheMelvin/ItemFactory.svg) 
![GitHub release](https://img.shields.io/github/release/TheMelvin/ItemFactory.svg)
## ItemFactory ##  
Create ItemStacks the easy way.  
  
### Installation ###  
Just browse to the `src/` folder and copy the `ItemFactory.java` to your own project or repository.  
  
### Usage  ###  
In this part I will show you how to use the ItemFactory, and what you can do with it.  
  
#### Create new instance ####  
Using the ItemFactory is pretty easy, first of all, create a new instance or use the static method provided to create one.  
  
```java  
new ItemFactory(Material material, int amount);  
```  
  
**or**  
  
```java  
ItemFactory.newFactory();  
```  
  
You can also create a new ItemFactory from an existing ItemStack by using:  
  
```java  
new ItemFactory(ItemStack itemStack);  
```  
  
#### Methods ####  
The ItemFactory has a lot of methods you can use to create your own ItemStack, let's have a look on what methods currently exist:  
  
Method | Function  
------------ | -------------  
setItemMeta(ItemMeta itemMeta) | Set the ItemMeta  
setType(Material material) | Set the Material
setAmount(int amount) | Set the amount
addEnchantment(Enchantment enchantment, int level) | Add an enchantment with level
addEnchantments(Map<Enchantment, Integer> enchantments) | Add multiple enchantments
addUnsafeEnchantment(Enchantment enchantment, int level) | Add an unsafe enchantment
addUnsafeEnchantments(Map<Enchantment, Integer> enchantments) | Add multiple unsafe enchantments
removeEnchantment(Enchantment enchantment) | Remove an enchantment
setDisplayName(String displayName) | Set the name of the ItemStack
addLoreLine(String line) | Add a new lore line
addLoreLines(String... lines) | Add multiple lore lines
setLore(List<String> lore) | Set the lore with with a list (resets all other lores)
setLore(String[] lore) | Set the lore with an array (resets all other lores)
removeLore(int index) | Remove a lore line by index
clearLore() | Clear the lore
setUnbreakable(boolean unbreakable) | Set whether the ItemStack must be unbreakable
setDamange(short damage) | Set the damage of the ItemStack
addItemFlag(ItemFlag... flags) | Add an ItemFlag
removeItemFlag(ItemFlag... flags) | Remove an ItemFlag
addAttributeModifier(Attribute attribute, AttributeModifier modifier) | Add an attribute modifier
removeAttributeModifier(Attribute attribute) | Remove an attribute modifier by attribute
removeAttributeModifier(EquipmentSlot attribute) | Remove an attribute modifier by EquipmentSlot
removeAttributeModifier(Attribute attribute, AttributeModifier modifier) | Remove an attribute modifier by attribute and modifier
setGlowing(boolean glowing) | Set if the ItemStack needs to glow
hideAttributes() | Hide all attributes
showAttributes() | Show all attributes

### Color codes ###
ItemFactory supports color codes! This means that whenerver you use a String with color codes (in the lore, for example), the method converts it to real colors, cool huh?

### Please note ###
This utility is made for **Spigot 1.13+**, using it in any other version might crash your plugin or server.
I'm not responsible for any problems occuring when using other versions. Do NOT report them.

### Contributing ###
If you find any problems or improvements in the code, you are free to create a pull request, I will then look into it as soon as possible. If any problems occur, please create an issue.

### JavaDocs ###
The JavaDocs can be found [here](https://javadocs.melvinsnijders.nl/itemfactory/). If something is missing, please contact me.

### Contact ###
Twitter: [@TheMelvinNL](https://twitter.com/TheMelvinNL)
Mail: [mail@melvinsnijders.nl](mailto:mail@melvinsders.nl)

### License ###
MIT License

Copyright (c) 2018 Melvin Snijders

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.