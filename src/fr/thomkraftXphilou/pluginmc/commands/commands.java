package fr.thomkraftXphilou.pluginmc.commands;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("test")){
                player.sendMessage("§cbravo tu a réussi §9le test");
                return true;
            }





            if(cmd.getName().equalsIgnoreCase("alert")) {

                if(args.length == 0) {
                    player.sendMessage("la commande est : /alert <message>");
                }


                if(args.length >= 1) {

                    StringBuilder bc = new StringBuilder();
                    for(String part : args) {
                        bc.append(" §6" + part);
                    }

                    Bukkit.broadcastMessage("§c[Alert] " + bc);

                }
                    return true;
                }

            if(cmd.getName().equalsIgnoreCase("kit")) {


                //verif trop arguments

                if(args.length >= 2 ){
                    player.sendMessage("§8§l[PRIVATE]§r Il y a trop d'argument !");
                    StringBuilder bc = new StringBuilder();
                    if(player.hasPermission("kit.joueur")){
                        bc.append("§ka§rJoueur§ka§r ");
                    }
                    if (player.hasPermission("kit.gap")){
                        bc.append(", §e§ka§r§eGAP§ka§r ");
                    }
                    if(player.hasPermission("kit.nodebuff")){
                        bc.append(", §5§ka§r§dKIT Nodebuff§5§ka§r ");
                    }
                    player.sendMessage("§8§l[PRIVATE]§r Les kits disponibles sont : " + bc);
                }else {

                    //verif ci jusst /kit

                    if (args.length == 0) {
                        StringBuilder bc = new StringBuilder();
                        if (player.hasPermission("kit.joueur")) {
                            bc.append("§ka§rJoueur§ka§r ");
                        }
                        if (player.hasPermission("kit.gap")){
                            bc.append(", §e§ka§r§eGAP§ka§r ");
                        }
                        if(player.hasPermission("kit.nodebuff")){
                            bc.append(", §5§ka§r§dKIT Nodebuff§5§ka§r ");
                        }
                        player.sendMessage("§8§l[PRIVATE]§r Les kits disponibles sont : " + bc);
                    } else {

                        //verif du 1er args

                        if (args[0].equalsIgnoreCase("joueur") && player.hasPermission("kit.joueur")) {
                            player.sendMessage("§8§l[PRIVATE]§r Tu a recu le kit §ka§rJoueur§ka§r !");

                            ItemStack customsword = new ItemStack(Material.STONE_SWORD);
                            ItemMeta customS = customsword.getItemMeta();
                            customS.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                            customS.setDisplayName("§ka§rKIT Joueur§ka");
                            customsword.setItemMeta(customS);


                            ItemStack customaxe = new ItemStack(Material.STONE_AXE);
                            ItemMeta customA = customaxe.getItemMeta();
                            customA.addEnchant(Enchantment.DIG_SPEED, 2, true);
                            customA.setDisplayName("§ka§rKIT Joueur§ka");
                            customaxe.setItemMeta(customA);


                            ItemStack custompickaxe = new ItemStack(Material.STONE_PICKAXE);
                            ItemMeta customP = custompickaxe.getItemMeta();
                            customP.addEnchant(Enchantment.DIG_SPEED, 2, true);
                            customP.setDisplayName("§ka§rKIT Joueur§ka");
                            custompickaxe.setItemMeta(customP);

                            ItemStack customsteak = new ItemStack(Material.COOKED_BEEF, 64);
                            ItemMeta customC = customsteak.getItemMeta();
                            customC.setDisplayName("§ka§rKIT Joueur§ka");
                            customsteak.setItemMeta(customC);


                            player.getInventory().addItem(customsword, customaxe, custompickaxe, customsteak);
                        } else if (args[0].equalsIgnoreCase("gap") && player.hasPermission("kit.gap")) {

                            player.sendMessage("§8§l[PRIVATE]§r Tu a recu le §e§ka§r§ekit gap§e§ka§r!");

                            //plastron p4 u4
                            ItemStack plastrond = new ItemStack(Material.DIAMOND_CHESTPLATE);
                            ItemMeta customplastron = plastrond.getItemMeta();
                            customplastron.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            customplastron.addEnchant(Enchantment.DURABILITY, 4, true);
                            customplastron.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            plastrond.setItemMeta(customplastron);

                            // casque p4 u4
                            ItemStack casqued = new ItemStack(Material.DIAMOND_HELMET);
                            ItemMeta customHelmet = casqued.getItemMeta();
                            customHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            customHelmet.addEnchant(Enchantment.DURABILITY, 4, true);
                            customHelmet.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            casqued.setItemMeta(customHelmet);

                            //pantalon p4 u4
                            ItemStack pantalond = new ItemStack(Material.DIAMOND_LEGGINGS);
                            ItemMeta custompantalon = pantalond.getItemMeta();
                            custompantalon.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            custompantalon.addEnchant(Enchantment.DURABILITY, 4,true);
                            custompantalon.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            pantalond.setItemMeta(custompantalon);

                            //bottes p4 u4
                            ItemStack bottesd = new ItemStack(Material.DIAMOND_BOOTS);
                            ItemMeta custombottes = bottesd.getItemMeta();
                            custombottes.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            custombottes.addEnchant(Enchantment.DURABILITY, 4,true);
                            custombottes.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            bottesd.setItemMeta(custombottes);

                            //notch apples
                            ItemStack notchapple = new ItemStack(Material.GOLDEN_APPLE, 64, (short)1);
                            ItemMeta customnotch = notchapple.getItemMeta();
                            customnotch.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            notchapple.setItemMeta(customnotch);

                            //épée t5 u3 f2
                            ItemStack epeed = new ItemStack(Material.DIAMOND_SWORD);
                            ItemMeta customepee = epeed.getItemMeta();
                            customepee.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                            customepee.addEnchant(Enchantment.DURABILITY, 3, true);
                            customepee.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                            customepee.setDisplayName("§e§ka§r§e§nKIT GAP§e§ka");
                            epeed.setItemMeta(customepee);

                            //potion force
                            ItemStack potion = new ItemStack(Material.POTION, 3);
                            PotionMeta potionforcemeta = (PotionMeta) potion.getItemMeta();
                            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 1800, 1, true, true);
                            PotionEffect strenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1, true, true);
                            PotionEffect fireresist = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9600, 1, true, true);
                            potionforcemeta.addCustomEffect(speed, true);
                            potionforcemeta.addCustomEffect(strenght, true);
                            potionforcemeta.addCustomEffect(fireresist, true);
                            potionforcemeta.setDisplayName("§c Potion force§r &§b Speed §r&§6 fire protection");
                            List<String> lore = new ArrayList<>();
                            lore.add("§c Strenght 2 (1:30)");
                            lore.add("§b Speed 2 (1:30)");
                            lore.add("§6 Fire resistance (8:00)");
                            potionforcemeta.setLore(lore);
                            potion.setItemMeta(potionforcemeta);

                            // give du stuff

                            player.getInventory().setChestplate(plastrond);
                            player.getInventory().setHelmet(casqued);
                            player.getInventory().setLeggings(pantalond);
                            player.getInventory().setBoots(bottesd);
                            player.getInventory().addItem(epeed, notchapple,casqued, plastrond, pantalond, bottesd, potion);


                        } else if(args[0].equalsIgnoreCase("nodebuff") && player.hasPermission("kit.nodebuff")){
                            player.sendMessage("§8§l[PRIVATE]§r Tu a recu le kit §5§ka§r§dKIT Nodebuff§5§ka§r !");

                            //epee t3 u3 f2

                            ItemStack epeed = new ItemStack(Material.DIAMOND_SWORD);
                            ItemMeta customepee = epeed.getItemMeta();
                            customepee.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                            customepee.addEnchant(Enchantment.DURABILITY, 3, true);
                            customepee.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                            customepee.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            epeed.setItemMeta(customepee);

                            //casque p3 u3

                            ItemStack casqued = new ItemStack(Material.DIAMOND_HELMET);
                            ItemMeta customcasque = casqued.getItemMeta();
                            customcasque.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                            customcasque.addEnchant(Enchantment.DURABILITY, 3, true);
                            customcasque.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            casqued.setItemMeta(customcasque);

                            //plastron p3 u3

                            ItemStack plastrond = new ItemStack(Material.DIAMOND_CHESTPLATE);
                            ItemMeta customplastron = plastrond.getItemMeta();
                            customplastron.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                            customplastron.addEnchant(Enchantment.DURABILITY, 3, true);
                            customplastron.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            plastrond.setItemMeta(customplastron);

                            //pantalon p3 u3

                            ItemStack pantalond = new ItemStack(Material.DIAMOND_LEGGINGS);
                            ItemMeta custompantalon = pantalond.getItemMeta();
                            custompantalon.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                            custompantalon.addEnchant(Enchantment.DURABILITY, 3, true);
                            custompantalon.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            pantalond.setItemMeta(custompantalon);

                            //bottes p3 u3

                            ItemStack bootesd = new ItemStack(Material.DIAMOND_BOOTS);
                            ItemMeta custombottes = bootesd.getItemMeta();
                            custombottes.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                            custombottes.addEnchant(Enchantment.DURABILITY, 3, true);
                            custombottes.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            bootesd.setItemMeta(custombottes);

                            //potion fire (2:00)/ speed 2 (1:30) * 4

                            ItemStack potion = new ItemStack(Material.POTION);
                            PotionMeta custompotion = (PotionMeta) potion.getItemMeta();
                            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 1800, 1, true, true);
                            PotionEffect fireresist = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2400, 1, true, true);
                            custompotion.addCustomEffect(speed, true);
                            custompotion.addCustomEffect(fireresist, true);
                            custompotion.setDisplayName("§bPotion Speed §r&§6 fire protection");
                            List<String> lore = new ArrayList<>();
                            lore.add("§b Speed 2 (1:30)");
                            lore.add("§6 Fire resistance (2:00)");
                            custompotion.setLore(lore);
                            potion.setItemMeta(custompotion);

                            // pearl 16

                            ItemStack pearl = new ItemStack(Material.ENDER_PEARL, 16);
                            ItemMeta metapearl = pearl.getItemMeta();
                            metapearl.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            pearl.setItemMeta(metapearl);

                            // steak 64

                            ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
                            ItemMeta metasteak = steak.getItemMeta();
                            metasteak.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            steak.setItemMeta(metasteak);

                            //potion de heal

                            ItemStack potionheal = new ItemStack(Material.POTION, 2,(short) 16421);
                            PotionMeta metapotionheal = (PotionMeta) potionheal.getItemMeta();
                            metapotionheal.setDisplayName("§5§ka§r§dKIT Nodebuff§5§ka");
                            potionheal.setItemMeta(metapotionheal);

                            //give du stuff

                            player.getInventory().setHelmet(casqued);
                            player.getInventory().setChestplate(plastrond);
                            player.getInventory().setLeggings(pantalond);
                            player.getInventory().setBoots(bootesd);

                            player.getInventory().setItem(1, potion);
                            player.getInventory().setItem(17, potion);
                            player.getInventory().setItem(26, potion);
                            player.getInventory().setItem(35, potion);
                            player.getInventory().setItem(8, pearl);
                            player.getInventory().setItem(9, steak);
                            player.getInventory().setItem(0, epeed);


                            for (int nb = 0; nb != 29; nb++){
                                player.getInventory().addItem(potionheal);
                            }



                        } else {

                            // ci pas la perms

                            player.sendMessage("§8§l[PRIVATE]§r Tu n'a pas la permission de recevoir ce kit !");
                            StringBuilder bc = new StringBuilder();
                            if (player.hasPermission("kit.joueur")) {
                                bc.append("§ka§rJoueur§ka§r ");
                            }
                            if (player.hasPermission("kit.gap")){
                                bc.append(", §e§ka§r§eGAP§ka§r ");
                            }
                            if(player.hasPermission("kit.nodebuff")){
                                bc.append(", §5§ka§r§dKIT Nodebuff§5§ka§r ");
                            }
                            player.sendMessage("[PRIVATE] Les kits disponibles sont : " + bc);
                        }
                    }
                }
            }else{
                StringBuilder bc = new StringBuilder();
                if(player.hasPermission("kit.joueur")){
                    bc.append("§ka§rJoueur§ka§r ");
                }
                if (player.hasPermission("kit.gap")){
                    bc.append(", §e§ka§r§eGAP§ka§r ");
                }
                if(player.hasPermission("kit.nodebuff")){
                    bc.append(", §5§ka§r§dKIT Nodebuff§5§ka§r ");
                }
                player.sendMessage("§8§l[PRIVATE]§r Les kits disponibles sont : " + bc);

            }
            if(cmd.getName().equalsIgnoreCase("start")) {

                int max = 300;
                int min = 100;

                int x = new Random().nextInt(max - min) + min;
                int z = new Random().nextInt(max - min) + min;

                Location loc = new Location(player.getWorld(), x, 0, z);

                int y = loc.getWorld().getHighestBlockYAt(loc) + 3;

                loc.setY(y);

                player.teleport(loc);

                player.sendMessage("tu a bien été téléporté aléatoirement en " + x +" " + y + " " + z);

            }
            if(cmd.getName().equalsIgnoreCase("spawn")){
                System.out.println("a");


            }




        }

        return false;
    }

}
