package WGHxPERNAxBEAST.BasicallyAnything.entities;

import WGHxPERNAxBEAST.BasicallyAnything.lists.TutEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.DefendVillageTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.MoveTowardsVillageGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.ShowVillagerFlowerGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class TutEntity extends IronGolemEntity{

	@SuppressWarnings("unchecked")
	public TutEntity(EntityType<? extends IronGolemEntity> type, World worldIn) {
		super((EntityType<? extends IronGolemEntity>) TutEntities.TUT_ENTITY, worldIn);
	}
	
	@Override
	protected void registerGoals() {
	      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, true));
	      this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));
	      this.goalSelector.addGoal(2, new MoveTowardsVillageGoal(this, 0.8D));
	      this.goalSelector.addGoal(3, new MoveThroughVillageGoal(this, 0.8D, false, 4, () -> {
	         return false;
	      }));
	      this.goalSelector.addGoal(5, new ShowVillagerFlowerGoal(this));
	      this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
	      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
	      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	      this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
	      this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
	         return p_213619_0_ instanceof IMob && !(p_213619_0_ instanceof CreeperEntity);
	      }));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
	    this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	    this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.5D);
	}
	
}
