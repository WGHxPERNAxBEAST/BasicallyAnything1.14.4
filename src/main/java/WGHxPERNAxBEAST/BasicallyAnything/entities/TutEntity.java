package WGHxPERNAxBEAST.BasicallyAnything.entities;

import WGHxPERNAxBEAST.BasicallyAnything.lists.TutEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsVillageGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;

public class TutEntity extends CreatureEntity{

	@SuppressWarnings("unchecked")
	public TutEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) TutEntities.TUT_ENTITY, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8d));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(1, new MoveTowardsVillageGoal(this, 0.9d));
		//this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.9d, false));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8d);
		//this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0d);
		//this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(7.0d);
		//this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0d);
	}
	
}
