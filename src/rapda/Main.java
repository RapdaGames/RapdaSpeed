package rapda;

import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.*;
import cn.nukkit.*;
import cn.nukkit.event.*;
import cn.nukkit.event.player.*;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.Config;

import java.util.List;

public class Main extends PluginBase implements Listener
{
    public List<String> allowLevels;

    public void onEnable() {
        super.onEnable();
        this.saveDefaultConfig();
        this.allowLevels = new Config(this.getDataFolder() + "/config.yml", 2).getStringList("AllowLevels");
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }

    public void onLoad() {
        super.onLoad();
    }

    public void onDisable() {
        super.onDisable();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        //开启的世界
        if (this.allowLevels.contains(player.getLevel().getName())){
            //方块XYZ算法
            Block block = event.getPlayer().getLevel().getBlock(new Vector3((double) (int) Math.round(event.getPlayer().x - 0.5), (double) (int) Math.round(event.getPlayer().y - 1.0), (double) (int) Math.round(event.getPlayer().z - 0.5)));
            //品红色带釉陶瓦
            if (block.getId() == 222) {
                switch (block.getId()) {
                    case 222: {

                        player.addEffect(Effect.getEffect(1).setAmplifier(4).setDuration(50).setVisible(false));
                    }
                }
            }
        }
    }
}