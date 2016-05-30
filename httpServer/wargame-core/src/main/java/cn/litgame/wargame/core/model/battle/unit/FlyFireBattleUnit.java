package cn.litgame.wargame.core.model.battle.unit;

import cn.litgame.wargame.core.auto.GameProtos;
import cn.litgame.wargame.core.auto.GameResProtos.BattleFieldType;
import cn.litgame.wargame.core.model.BattleTroop;
import cn.litgame.wargame.core.model.battle.Damage;

import java.util.List;
import java.util.Map;

/**
 *火炮类型
 * 
 * @author 熊纪元
 *
 */
public class FlyFireBattleUnit extends BattleUnit {
	private static final BattleFieldType[] order = {
			BattleFieldType.FIELD_FIRE,
			BattleFieldType.FIELD_REMOTE,
			BattleFieldType.FIELD_CLOSE,
			BattleFieldType.FIELD_SIDE
	};
	
	public FlyFireBattleUnit(BattleTroop bt, int count, long playerId, int cityId) {
		super(bt, count, playerId, cityId);
	}

	public FlyFireBattleUnit(GameProtos.BattleUnit unit) {
		super(unit);
	}
	
	@Override
	public BattleFieldType[] getOrder() {
		return FlyFireBattleUnit.order;
	}

	@Override
	public void doAction(Map<BattleFieldType, List<BattleUnit>> enemy, Map<BattleFieldType, List<BattleUnit>> self,
			Map<BattleFieldType, Damage> targetDamages) {
		int totalDamage = 0;
		int targetCount = 0;
		double percent = 0;
		
		if(this.amount > 0){
			percent = this.percent2;
			totalDamage = this.attack2;
			this.amount--;
		}else{
			return;
		}
		
		targetCount = getTargetCount(totalDamage, percent);
		this.attack(enemy, targetCount, totalDamage, targetDamages);
	}
}
