import com.entities.Character;
import com.entities.IEntity;
import com.entities.Item;
import com.entities.Item.Items;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.playerInput.ActionChoice;
import com.playerInput.ActionChoice.Icons;
import com.sequences.CharacterCreation;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;

import javax.swing.Icon;

import com.actions.*;

public class ShortStory implements IStory {
	 private Character Edric;
	    private Character GeneralEduart;
	    private Character SoldierHale;
	    private Character SoldierFrye;
	    private Character SoldierWinfred;
	    private Character MurdererRoki;
	    private Character LadyMarina;
	    private Character LadyKasumi;
	    private Character SuspectHumphrey;
	    private Character CustomerAleksey;
	    private Character BartenderMeier;
	    private Place Tavern;
	    private Place StarterPlace;
	    private Place City;
	    private Place Tarven;
	    private Place Port;
	    private Place CourtYard;
	    private Place Cottage1;
	    private Place Cottage2;
	    private Place Dungeon;
	    private Place AlchemyShop;
	    private Item Skull;
	    private Item Cup;
	    private Item Ledger;
	    private Item Soporific;
	    private String Talk = "Talk";
	    private Icons talk = Icons.talk;
	    private ActionChoice actionChoice1 = new ActionChoice("Talk", GeneralEduart, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice2 = new ActionChoice("Talk", SoldierHale, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice3 = new ActionChoice("Talk", SoldierWinfred, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice4 = new ActionChoice("Talk", SoldierFrye, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice5 = new ActionChoice("Talk", LadyMarina, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice6 = new ActionChoice("Talk", LadyKasumi, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice7 = new ActionChoice("Talk", CustomerAleksey, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice8 = new ActionChoice("Talk", BartenderMeier, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice9 = new ActionChoice("Talk", MurdererRoki, Icons.talk, "Talk", true);
	    //private ActionChoice actionChoice10 = new ActionChoice("Talk", BartenderMeier, Icons.talk, "Talk", true);
	    
	
	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getRoot() {
		// TODO Auto-generated method stub
		return new Node("root");
	}

	@Override
	public void getThings() {
		Edric = new Character(ThingNames.Tom.toString());
        GeneralEduart = new Character(ThingNames.GeneralEduart.toString());
        StarterPlace = new Place(ThingNames.Home.toString(), Place.Places.Bridge);
        CourtYard = new Place(ThingNames.CourtYard.toString(), Place.Places.Courtyard);
        Port = new Place(ThingNames.Port.toString(), Place.Places.Port);
        Tavern = new Place(ThingNames.Tavern.toString(), Place.Places.Tavern);
        Cottage1 = new Place(ThingNames.Cottage1.toString(), Place.Places.Cottage);
        Cottage2 = new Place(ThingNames.Cottage2.toString(), Place.Places.Cottage);
        Dungeon = new Place(ThingNames.Dungeon.toString(), Place.Places.Dungeon);
        City = new Place(ThingNames.City.toString(), Place.Places.City);
        AlchemyShop = new Place(ThingNames.AlchemyShop.toString(), Place.Places.AlchemyShop);
        SoldierFrye = new Character(ThingNames.SoldierFrye.toString());
        SoldierHale = new Character(ThingNames.SoldierHale.toString());
        SoldierWinfred = new Character(ThingNames.SoldierWinfred.toString());
        MurdererRoki = new Character(ThingNames.MurdererRoki.toString());
        LadyMarina = new Character(ThingNames.LadyMarina.toString());
        LadyKasumi = new Character(ThingNames.LadyKasumi.toString());
        SuspectHumphrey = new Character(ThingNames.SuspectHumphrey.toString());
        CustomerAleksey = new Character(ThingNames.CustomerAleksey.toString());
        BartenderMeier = new Character(ThingNames.BartenderMeier.toString());
        Soporific = new Item(ThingNames.GreenPotion.toString(), Items.GreenPotion);
        Skull = new Item(ThingNames.Skull.toString(), Items.Skull);
        Cup = new Item(ThingNames.Cup.toString(), Items.Cup);
        Ledger = new Item(ThingNames.OpenScroll.toString(), Items.OpenScroll);
		
		
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Edric));
		sequence.combineWith(new CharacterCreation(GeneralEduart));
		sequence.add(new Create<Place>(StarterPlace));
		sequence.add(new Position(Edric, StarterPlace));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getStartSequence() {
		var sequence=new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getSpeakToGuardSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice1));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	
	private ActionSequence getExitStarterPlaceViaTeleportSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, StarterPlace.getFurniture("NorthSign"), true));
		return sequence;
	}
	
	private ActionSequence getEnterAlchemyShopSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(SoldierHale));
		sequence.combineWith(new CharacterCreation(SoldierFrye));
		sequence.combineWith(new CharacterCreation(SoldierWinfred));
		sequence.combineWith(new CharacterCreation(LadyMarina));
		sequence.add(new Create<Place>(AlchemyShop));
		sequence.add(new Position(Edric, AlchemyShop));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierHaleSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierHale));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice2));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	
	private ActionSequence getSpeakWithSoldierWinfredSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierWinfred));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice3));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierFryeSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierFrye));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice4));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyMarinaSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyMarina));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice5));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getExitAlchemyShopViaTeleportSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, AlchemyShop.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getEnterCitySequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(LadyKasumi));
		sequence.add(new Create<Place>(City));
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyKasumiSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyKasumi));
		sequence.add(new SetDialog("TBW"));
		//Implement Exiting City for pier option later
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice6));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getEnterPierSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(MurdererRoki));
		//Add other 2 guards later
		sequence.add(new Create<Place>(Port));
		sequence.add(new Position(Edric, Port));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	//Add Exit Via Guard Option Later
	
	private ActionSequence getSpeakWithMurdererRokiSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(MurdererRoki));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice6));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	//Implement Exiting City for pier option later
	
	private ActionSequence getCityToTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Tavern.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getEnterTavernSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(BartenderMeier));
		sequence.combineWith(new CharacterCreation(CustomerAleksey));
		//Add Mug Later To Table
		sequence.add(new Create<Place>(Tavern));
		sequence.add(new Position(Edric, StarterPlace));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithCustomerAlekseySequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(CustomerAleksey));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice7));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithBartenderMeierSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(BartenderMeier));
		sequence.add(new SetDialog("TBW"));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice8));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getExitTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Tavern.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getEnterCottageSequence() {
		var sequence = new ActionSequence();
		//Add Items
		sequence.add(new Create<Place>(Cottage1));
		sequence.add(new Position(Edric, Cottage1));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	//Add Interacting with the Items and such Later
	
	private ActionSequence getExitCottageSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Cottage1.getFurniture("Door"), true));
		return sequence;
	}
	
	
	
	
	
	

}
