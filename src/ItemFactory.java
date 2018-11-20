/* Copyright 2018 Melvin Snijders
 *
 * Licensed under the MIT License.
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://spdx.org/licenses/MIT.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ItemFactory - Build your {@link ItemStack} the easy way. (1.13)
 * @version 1.0.0
 * @author Melvin Snijders
 * @since 20/11/2018
 */

public class ItemFactory {

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> lore = new ArrayList<>();

    /**
     * Construct ItemFactory class with given {@link Material}.
     * @since 1.0.0
     */

    public ItemFactory(Material material) {

        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();

    }

    /**
     * Construct ItemFactory class with given {@link Material} and amount.
     * @since 1.0.0
     */

    public ItemFactory(Material material, int amount) {

        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();

    }

    public ItemFactory(ItemStack itemStack) {

        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        this.lore = this.itemMeta.getLore();

    }

    public static ItemFactory newFactory(Material material) {

        return new ItemFactory(material);

    }

    public ItemFactory setItemMeta(ItemMeta itemMeta) {

        this.itemMeta = itemMeta;
        return this;

    }

    public ItemFactory setType(Material material) {

        this.itemStack.setType(material);
        return this;

    }

    public ItemFactory setAmount(int amount) {

        this.itemStack.setAmount(amount);
        return this;

    }

    public ItemFactory addEnchantment(Enchantment enchantment, int level) {

        this.itemStack.addEnchantment(enchantment, level);
        return this;

    }

    public ItemFactory addEnchantments(Map<Enchantment, Integer> enchantments) {

        this.itemStack.addEnchantments(enchantments);
        return this;

    }

    public ItemFactory addUnsafeEnchantment(Enchantment enchantment, int level) {

        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;

    }

    public ItemFactory addUnsafeEnchantments(Map<Enchantment, Integer> enchantments) {

        this.itemStack.addUnsafeEnchantments(enchantments);
        return this;

    }

    public ItemFactory removeEnchantment(Enchantment enchantment) {

        this.itemStack.removeEnchantment(enchantment);
        return this;

    }

    public ItemFactory setDisplayName(String displayName) {

        this.itemMeta.setDisplayName(color(displayName));
        return this;

    }

    public ItemFactory addLoreLine(String line) {

        this.lore.add(line);
        return this;

    }

    public ItemFactory addLoreLines(String... lines) {

        this.lore.addAll(Arrays.asList(lines));
        return this;

    }

    public ItemFactory setLore(List<String> lore) {

        this.lore = lore;
        return this;

    }

    public ItemFactory setLore(String[] lore) {

        this.lore = Arrays.asList(lore);
        return this;

    }

    public ItemFactory removeLore(int index) {

        this.lore.remove(index);
        return this;

    }

    public ItemFactory clearLore() {

        this.lore.clear();
        return this;

    }

    public ItemFactory setUnbreakable(boolean unbreakable) {

        this.itemMeta.setUnbreakable(unbreakable);
        return this;

    }

    public ItemFactory setDamange(short damage) {

        ((Damageable) this.itemMeta).setDamage(damage);
        return this;

    }

    private String color(String color) {

        return ChatColor.translateAlternateColorCodes('&', color);

    }

    public ItemFactory addItemFlag(ItemFlag... flags) {

        this.itemMeta.addItemFlags(flags);
        return this;

    }

    public ItemFactory removeItemFlag(ItemFlag... flags) {

        this.itemMeta.removeItemFlags(flags);
        return this;

    }

    public ItemFactory addAttributeModifier(Attribute attribute, AttributeModifier modifier) {

        this.itemMeta.addAttributeModifier(attribute, modifier);
        return this;

    }

    public ItemFactory removeAttributeModifier(Attribute attribute) {

        this.itemMeta.removeAttributeModifier(attribute);
        return this;

    }

    public ItemFactory removeAttributeModifier(EquipmentSlot attribute) {

        this.itemMeta.removeAttributeModifier(attribute);
        return this;

    }

    public ItemFactory removeAttributeModifier(Attribute attribute, AttributeModifier modifier) {

        this.itemMeta.removeAttributeModifier(attribute, modifier);
        return this;

    }

    public ItemFactory setGlowing(boolean glowing) {

        Enchantment enchantment = this.itemStack.getType() != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK;

        if(glowing) {
            this.removeEnchantment(enchantment);
            this.removeItemFlag(ItemFlag.HIDE_ENCHANTS);
        } else {
            this.addEnchantment(enchantment, 10);
            this.addItemFlag(ItemFlag.HIDE_ENCHANTS);
        }

        return this;

    }

    public ItemFactory hideAttributes() {

        this.addItemFlag(ItemFlag.HIDE_ATTRIBUTES);
        return this;

    }

    public ItemFactory showAttributes() {

        this.removeItemFlag(ItemFlag.HIDE_ATTRIBUTES);
        return this;

    }


    /**
     * Build the {@link ItemStack}.
     * @return The newly created {@link ItemStack}.
     * @since 1.0.0
     */

    public ItemStack build() {

        List<String> newLore = new ArrayList<>();
        this.lore.forEach((lore) -> newLore.add(color(lore)));

        this.itemMeta.setLore(newLore);
        this.itemStack.setItemMeta(this.itemMeta);

        return itemStack;

    }

}
