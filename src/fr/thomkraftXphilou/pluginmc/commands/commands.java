package fr.thomkraftXphilou.pluginmc.commands;

import java.io.Console;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
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
                    player.sendMessage("[PRIVATE] Il y a trop d'argument !");
                    StringBuilder bc = new StringBuilder();
                    if(player.hasPermission("kit.joueur")){
                        bc.append("Joueur ");
                    }
                    if(player.hasPermission("kit.vip")){
                        bc.append(", VIP ");
                    }
                    if (player.hasPermission("kit.gap")){
                        bc.append(", gap ");
                    }
                    player.sendMessage("[PRIVATE] Les kits disponibles sont : " + bc);
                }else {

                    //verif ci jusst /kit

                    if (args.length == 0) {
                        StringBuilder bc = new StringBuilder();
                        if (player.hasPermission("kit.joueur")) {
                            bc.append("Joueur ");
                        }
                        if (player.hasPermission("kit.vip")) {
                            bc.append(", VIP ");
                        }
                        if (player.hasPermission("kit.gap")){
                            bc.append(", gap ");
                        }
                        player.sendMessage("[PRIVATE] Les kits disponibles sont : " + bc);
                    } else {

                        //verif du 1er args

                        if (args[0].equalsIgnoreCase("joueur") && player.hasPermission("kit.joueur")) {
                            player.sendMessage("[PRIVATE] Tu a recu le kit joueur !");

                            ItemStack customsword = new ItemStack(Material.STONE_SWORD);
                            ItemMeta customS = customsword.getItemMeta();
                            customS.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                            customsword.setItemMeta(customS);


                            ItemStack customaxe = new ItemStack(Material.STONE_AXE);
                            ItemMeta customA = customaxe.getItemMeta();
                            customA.addEnchant(Enchantment.DIG_SPEED, 2, true);
                            customaxe.setItemMeta(customA);


                            ItemStack custompickaxe = new ItemStack(Material.STONE_PICKAXE);
                            ItemMeta customP = custompickaxe.getItemMeta();
                            customP.addEnchant(Enchantment.DIG_SPEED, 2, true);
                            custompickaxe.setItemMeta(customP);

                            ItemStack customsteak = new ItemStack(Material.COOKED_BEEF, 64);
                            ItemMeta customC = customsteak.getItemMeta();
                            customsteak.setItemMeta(customC);


                            player.getInventory().addItem(customsword, customaxe, custompickaxe, customsteak);
                        } else if (args[0].equalsIgnoreCase("vip") && player.hasPermission("kit.vip")) {

                            Bukkit.broadcastMessage("§6 c'est sencé donner le kit vip mais pas encore fais lol");

                        } else if (args[0].equalsIgnoreCase("gap") && player.hasPermission("kit.gap")) {

                            //plastron p4 u4
                            ItemStack plastrond = new ItemStack(Material.DIAMOND_CHESTPLATE);
                            ItemMeta customplastron = plastrond.getItemMeta();
                            customplastron.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            customplastron.addEnchant(Enchantment.DURABILITY, 4, true);
                            plastrond.setItemMeta(customplastron);

                            // casque p4 u4
                            ItemStack casqued = new ItemStack(Material.DIAMOND_HELMET);
                            ItemMeta customHelmet = casqued.getItemMeta();
                            customHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            customHelmet.addEnchant(Enchantment.DURABILITY, 4, true);
                            casqued.setItemMeta(customHelmet);

                            //pantalon p4 u4
                            ItemStack pantalond = new ItemStack(Material.DIAMOND_LEGGINGS);
                            ItemMeta custompantalon = pantalond.getItemMeta();
                            custompantalon.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            custompantalon.addEnchant(Enchantment.DURABILITY, 4,true);
                            pantalond.setItemMeta(custompantalon);

                            //bottes p4 u4
                            ItemStack bottesd = new ItemStack(Material.DIAMOND_BOOTS);
                            ItemMeta custombottes = bottesd.getItemMeta();
                            custombottes.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                            custombottes.addEnchant(Enchantment.DURABILITY, 4,true);
                            bottesd.setItemMeta(custombottes);

                            //notch apples
                            ItemStack notchapple = new ItemStack(Material.GOLDEN_APPLE, 64, (short)1);
                            ItemMeta customnotch = notchapple.getItemMeta();
                            notchapple.setItemMeta(customnotch);

                            //épée t5 u3 f2
                            ItemStack epeed = new ItemStack(Material.DIAMOND_SWORD);
                            ItemMeta customepee = epeed.getItemMeta();
                            customepee.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                            customepee.addEnchant(Enchantment.DURABILITY, 3, true);
                            customepee.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                            customepee.setDisplayName("§n§e KIT GAP");
                            epeed.setItemMeta(customepee);

                            //potion force
                            ItemStack potion = new ItemStack(Material.POTION);
                            PotionMeta potionforcemeta = (PotionMeta) potion.getItemMeta();
                            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2200, 1, true, true);
                            PotionEffect strenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2200, 1, true, true);
                            PotionEffect fireresist = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 1, true, true);
                            potionforcemeta.addCustomEffect(speed, true);
                            potionforcemeta.addCustomEffect(strenght, true);
                            potionforcemeta.addCustomEffect(fireresist, true);
                            potionforcemeta.setDisplayName("§c Potion force§r &§b Speed §r&§6 fire protection");
                            potion.setItemMeta(potionforcemeta);

                            player.getInventory().setChestplate(plastrond);
                            player.getInventory().setHelmet(casqued);
                            player.getInventory().setLeggings(pantalond);
                            player.getInventory().setBoots(bottesd);
                            player.getInventory().addItem(epeed, notchapple,casqued, plastrond, pantalond, bottesd, potion);



                        } else {

                            // ci pas la perms

                            player.sendMessage("[PRIVATE] Tu n'a pas la permission de recevoir ce kit !");
                            StringBuilder bc = new StringBuilder();
                            if (player.hasPermission("kit.joueur")) {
                                bc.append("Joueur ");
                            }
                            if (player.hasPermission("kit.vip")) {
                                bc.append(", VIP ");
                            }
                            if (player.hasPermission("kit.gap")){
                                bc.append(", gap ");
                            }
                            player.sendMessage("[PRIVATE] Les kits disponibles sont : " + bc);
                        }
                    }
                }
            }else{
                StringBuilder bc = new StringBuilder();
                if(player.hasPermission("kit.joueur")){
                    bc.append("Joueur ");
                }
                if(player.hasPermission("kit.vip")){
                    bc.append(", VIP ");
                }
                if (player.hasPermission("kit.gap")){
                    bc.append(", gap ");
                }
                player.sendMessage("[PRIVATE] Les kits disponibles sont : " + bc);

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



            }




        }

        return false;
    }

}
