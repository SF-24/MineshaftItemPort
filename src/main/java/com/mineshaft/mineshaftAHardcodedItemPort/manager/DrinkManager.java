package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.dre.brewery.Brew;
import com.dre.brewery.api.BreweryApi;
import com.mineshaft.mineshaftAHardcodedItemPort.MineshaftItemPort;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class DrinkManager {

    public static int getBrewModelData(Brew brew, Container container) {
        System.out.println("BREW: " + BreweryApi.getRecipeName(brew));
        System.out.println("MODEL: " + ConfigBridge.getCustomModelDataOfBrew(BreweryApi.getRecipeName(brew), container));
        return ConfigBridge.getCustomModelDataOfBrew(BreweryApi.getRecipeName(brew), container);
    }


    public static boolean isDrink(String name) {
        if(name==null)return false;
        for(Drinks drink :Drinks.values()) {
            if(drink.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static Drinks getDrink(String name) {
        if(name==null)return null;
        for(Drinks drink :Drinks.values()) {
            if(drink.name().equalsIgnoreCase(name)) {
                return drink;
            }
        }
        return null;
    }

    public static boolean isDrink(ItemStack item) {
        return getDrink(item) != null;
    }

    public static Drinks getDrink(ItemStack item) {
        if(item==null) return null;
        try {
            NBT.get(item, nbt -> {
                return Drinks.valueOf(nbt.getString("Drink").toUpperCase());
            });
        } catch(IllegalArgumentException e) {
            return null;
        }
        return null;
    }

    public static ArrayList<String> getPossibleContainers(Drinks drink) {
        if(drink==null) return null;
        ArrayList<String> possibleContainers = new ArrayList<>();
        if(drink.getTankardModelData()>=0) possibleContainers.add("bottle");
        if(drink.getBowlModelData()>=0) possibleContainers.add("bowl");
        if(drink.getBottleModelData()>=0) possibleContainers.add("tankard");
        return possibleContainers;
    }

    public static ItemStack getPlacedDrink(Drinks drink, Container container) {
        return getPlacedTankard(drink.getPlacedDrinks(), container);
    }

    public static ItemStack getPlacedTankard(PlaceableDrinks drink, Container container) {
        if(container.equals(Container.TANKARD)) {
            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();

            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", drink.getTextureUrl()));
            Field field;
            try {
                assert meta != null;
                field=meta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(meta, profile);
            } catch (RuntimeException e) {
                return null;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            is.setItemMeta(meta);
            return is;
        }
        return null;
    }

    public static GameProfile getPlaceableDrinkGameProfile(PlaceableDrinks drink, Container container) {
        if(container.equals(Container.TANKARD)) {
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", drink.getTextureUrl()));
            return profile;
        }
        return null;
    }

    public static PlayerProfile getPlacedTankardProfile(PlaceableDrinks drink, Container container) {
        if(container.equals(Container.TANKARD)) {
            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();

            is.setItemMeta(meta);

            PlayerProfile profile1 = MineshaftItemPort.getInstance().getServer().createPlayerProfile(UUID.randomUUID(),null);
            PlayerTextures textures = profile1.getTextures();
            try {
                URL url = new URL(drink.getTextureUrl());
                textures.setSkin(url, PlayerTextures.SkinModel.CLASSIC);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            return profile1;
        }
        return null;
    }


}
