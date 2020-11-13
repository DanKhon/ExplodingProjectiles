package com;

import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.entity.projectile.EntityEgg;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.level.Explosion;
import cn.nukkit.level.Location;

public class Shoot implements Listener {

    @EventHandler
    public void shoot(ProjectileHitEvent e) {

        if(e.getEntity() instanceof EntitySnowball && Main.snowballs){
            explode(e);
            return;
        }
        if(e.getEntity() instanceof EntityArrow && Main.arrows){
            explode(e);
            return;
        }
        if(e.getEntity() instanceof EntityEgg && Main.eggs){
            explode(e);
        }
    }
    public void explode(ProjectileHitEvent e){
        Explosion a = new Explosion(e.getEntity().getPosition(), Main.config.getDouble("size"), e.getEntity());

        a.explodeA();
        a.explodeB();
        e.getEntity().despawnFromAll();
        e.getEntity().teleport(new Location(0,0,0));
    }
}
