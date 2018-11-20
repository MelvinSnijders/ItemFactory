## ItemFactory ##
Create ItemStacks the easy way.

#### Installation ####
Just browse to the `src/` folder and copy the `ItemFactory.java` to your own project or repository.

#### Usage  ####
In this part I will show you how to use the ItemFactory, and what you can do with it.

##### Create new instance #####
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
