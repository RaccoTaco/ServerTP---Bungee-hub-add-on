package raccotaco.server;

import java.io.File;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class ServerTP extends JavaPlugin implements Listener
{
    public void onEnable() 
    {
        if (!new File(getDataFolder(), "config.yml").exists())
            this.saveDefaultConfig();
	saveConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    public void onDisable() 
    {}
    
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event)
    {
        if (event.getPlayer().isOnline())
        {
            Player p = event.getPlayer();
            p.teleport(p.getWorld().getSpawnLocation());
            
            Location loc = p.getLocation();
            loc.setYaw((float) getConfig().getDouble("getYaw"));
            loc.setPitch((float) getConfig().getDouble("getPitch"));
            loc.setX(getConfig().getDouble("getX"));
            loc.setY(getConfig().getDouble("getY"));
            loc.setZ(getConfig().getDouble("getZ"));
            p.teleport(loc);
        }
    }
    
}
