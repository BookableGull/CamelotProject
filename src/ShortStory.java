import com.entities.Character;
import com.entities.Character.BodyType;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyles;
import com.entities.Furniture;
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
	//note, not all objects here are used
	 	private Character Edric;
	    private Character GeneralEduart;
	    private Character SoldierHale;
	    private Character SoldierFrye;
	    private Character SoldierWinfred;
	    private Character Roki;
	    private Character LadyMarina;
	    private Character LadyKasumi;
	    private Character SuspectHumphrey;
	    private Character Rimmons;
	    private Character BartenderMeier;
	    private Character SoldierTyre;
	    private Character SoldierStani;
	    private Character OpponentShopKeeper;
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
	    private Item GreenPotion;
	    private Item Cup;
	    private Item Ledger;
	    private Item Soporific;
	    private Item Book;
	    private Item Scroll;
	    private String Talk = "Talk";
	    private Icons talk = Icons.talk;
	    private ActionChoice actionChoice1 = new ActionChoice("Talk", GeneralEduart, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice2 = new ActionChoice("Talk", SoldierHale, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice3 = new ActionChoice("Talk", SoldierWinfred, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice4 = new ActionChoice("Talk", SoldierFrye, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice5 = new ActionChoice("Talk", LadyMarina, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice6 = new ActionChoice("Talk", LadyKasumi, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice7 = new ActionChoice("Talk", Rimmons, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice8 = new ActionChoice("Talk", BartenderMeier, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice9 = new ActionChoice("Talk", Roki, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice10 = new ActionChoice("Talk", SoldierTyre, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice11 = new ActionChoice("Talk", SoldierStani, Icons.talk, "Talk", true);
	    
	    //Note, not all enums are used
	    private enum NodeLabels{
			Init, Start, AbilityToOpenInventory, BeginTalkWithGuard, ExitAreaViaTeleport,
			SpeakWithSoldierHale, AcceptCup, AddCupToInventory, ExitAlchemyShop, ContinueExploring, WarpToCity, ExitCityToDungeonGoodEnding, Promotion, endFade,
			EnterAlchemyShop, TalkToGuard2, TalkToGuard3, TeleportToShopViaGeneral, GoodChoiceFrye, BadChoiceFrye, DialogForCorrectEvidenceForApprentice, ShowEvidenceForApprentice,
			BadEndingForShoppKeeper, TeleportToDungeonForBadEnding, GiveRightEvidenceToEduartForShopKeeper, ShowEvidenceForOpponentShopKeeper,
			TalkToApprentice, Continue, LessIdealAnswerwithHale, BetterOptionWinfred, WorseOptionWinfred, ContinueWinfred, GoodOptionKasumi, BadOptionKasumi, TeleportToPier, SayNoToPier,
			OpenTavernDoor, EnterTavern, SpeakToDrunkMan1, ExitConversation, SpeakToDrunkMan2, SpeakToBarTender, EndConversationAfterListening, PickUpBook, PutBookInInventory,
			EnterCity, SpeakWithLady, ChooseToContinueInCity, ChooseToGoToPort, LeaveCity, SpeakWithCustomerAleksey, SayNoToKnowingKiller, ShowEvidenceForRoki,
			OpenCottageDoor, EnterCottage, ReadScroll, AddScrollToInventory, ClickOnPotion, AddPotionToInventory, YesToKnowingKiller, ShowProof, NoProof, OkayFromGeneralToGoodChoice, GiveWrongItemForRightChoice,
			SpeakWithGuard, YouDLikeToContinueSearching, YouDLikeToMakeAVerdict, PickShopKeeper, BadEnding1, PickSuspiciousMan, GoodEnding, PickApprentice,
			EnterPort, TalkToGuard5, TalkToMan, TalkToGuard6, DialogOptionOne, DialogOptionTwo, GoodOptionFromMeiser, GoodOptionFromGoodOptionFromMeiser, BadOptionFromMeiser, BadOptionFromGoodOptionMeiser, SpeakToGuard, AddBookToInventory, SpeakwithSoldierHale, IdealAnswerwithHale, speakwithsoldierwinfred, Speakwithsoldierfrye, SpeakwithladyMarina, SpeakwithLadyKasumi, Speakwithsoldierstani, Speakwithroki, Speakwithsoldiertyre, CitytoTavern, SpeakwithRimmons, BadOptionFromGoodOptionFromMeiser, ExitTavern, ExitCottage, SpeakWithGeneralEduarttogivedecision, BadEndingForShoppKeeperDialog, BadEndingDialog, PickUpScroll, CloseandPutDownScroll, PickUpPotionandAddToInventory, getGoodAnswerFromTyreforfirstquestion, NeutralAnswerFromTyre, FinalDialogFromTyre, DoNotLeavePierYet, ExitPier
			}
	
	@Override
	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.Init.toString(), getInitSequence());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.SpeakToGuard.toString(), getSpeakToGuardSequence());
		map.add(NodeLabels.TeleportToShopViaGeneral.toString(),getTeleportToShopViaGeneralSequence());
		map.add(NodeLabels.EnterAlchemyShop.toString(), getEnterAlchemyShopSequence());
		map.add(NodeLabels.PickUpBook.toString(), getPickUpBookSequence());
		map.add(NodeLabels.AddBookToInventory.toString(),getAddBookToInventorySequence());
		map.add(NodeLabels.SpeakwithSoldierHale.toString(),getSpeakWithSoldierHaleSequence());
		map.add(NodeLabels.IdealAnswerwithHale.toString(),getIdealAnswerwithHaleSequence());
		map.add(NodeLabels.LessIdealAnswerwithHale.toString(),getLessIdealAnswerwithHaleSequence());
		map.add(NodeLabels.Continue.toString(),getContinueSequence());
		map.add(NodeLabels.speakwithsoldierwinfred.toString(),getSpeakWithSoldierWinfredSequence());
		map.add(NodeLabels.BetterOptionWinfred.toString(),getBetterOptionWinfredSequence());
		map.add(NodeLabels.WorseOptionWinfred.toString(),getWorseOptionWinfredSequence());
		map.add(NodeLabels.ContinueWinfred.toString(),getContinueWinfredSequence());
		map.add(NodeLabels.Speakwithsoldierfrye.toString(),getSpeakWithSoldierFryeSequence());
		map.add(NodeLabels.GoodChoiceFrye.toString(),getGoodChoiceFryeSequence());
		map.add(NodeLabels.BadChoiceFrye.toString(),getBadChoiceFryeSequence());
		map.add(NodeLabels.SpeakwithladyMarina.toString(),getSpeakWithLadyMarinaSequence());
		map.add(NodeLabels.ExitAlchemyShop.toString(),getExitAlchemyShopViaTeleportSequence());
		map.add(NodeLabels.EnterCity.toString(),getEnterCitySequence());
		map.add(NodeLabels.SpeakwithLadyKasumi.toString(),getSpeakWithLadyKasumiSequence());
		map.add(NodeLabels.GoodOptionKasumi.toString(),getGoodOptionKasumiSequence());
		map.add(NodeLabels.BadOptionKasumi.toString(),getBadOptionKasumiSequence());
		map.add(NodeLabels.TeleportToPier.toString(),getTeleportToPierSequence());
		map.add(NodeLabels.SayNoToPier.toString(),getSayNoToPierSequence());
		map.add(NodeLabels.EnterPort.toString(),getEnterPierSequence());
		map.add(NodeLabels.Speakwithsoldierstani.toString(),getSpeakWithSoliderStaniSequence());
		map.add(NodeLabels.DoNotLeavePierYet.toString(), getDoNotLeavePierYetSequence());
		map.add(NodeLabels.ExitPier.toString(), getExitPierSequence());
		map.add(NodeLabels.Speakwithroki.toString(),getSpeakWithRokiSequence());
		map.add(NodeLabels.Speakwithsoldiertyre.toString(),getSpeakWithSoldierTyreSequence());
		map.add(NodeLabels.getGoodAnswerFromTyreforfirstquestion.toString(), getGoodAnswerFromTyreforfirstquestionSequence());
		map.add(NodeLabels.NeutralAnswerFromTyre.toString(), getNeutralAnswerFromTyreSequence());
		map.add(NodeLabels.FinalDialogFromTyre.toString(), getFinalDialogFromTyreSequence());
		map.add(NodeLabels.AddCupToInventory.toString(), getAddCupToInventorySequence());
		map.add(NodeLabels.CitytoTavern.toString(),getCityToTavernSequence());
		map.add(NodeLabels.EnterTavern.toString(),getEnterTavernSequence());
		map.add(NodeLabels.SpeakwithRimmons.toString(),getSpeakWithRimmonsSequence());
		map.add(NodeLabels.SpeakToBarTender.toString(),getSpeakWithBartenderMeierSequence());
		map.add(NodeLabels.GoodOptionFromMeiser.toString(),getGoodOptionFromMeiserSequence());
		map.add(NodeLabels.GoodOptionFromGoodOptionFromMeiser.toString(),getGoodOptionFromGoodOptionFromMeiserSequence());
		map.add(NodeLabels.BadOptionFromMeiser.toString(),getBadOptionFromMeiserSequence());
		map.add(NodeLabels.BadOptionFromGoodOptionFromMeiser.toString(),getBadOptionFromGoodOptionMeiserSequence());
		map.add(NodeLabels.ExitTavern.toString(),getExitTavernSequence());
		map.add(NodeLabels.EnterCottage.toString(),getEnterCottageSequence());
		map.add(NodeLabels.PickUpScroll.toString(), getPickUpScrollSequence());
		map.add(NodeLabels.ReadScroll.toString(),getReadScrollSequence());
		map.add(NodeLabels.CloseandPutDownScroll.toString(), getCloseandPutDownScrollSequence());
		map.add(NodeLabels.PickUpPotionandAddToInventory.toString(), getPickUpPotionandAddtoInventorySequence());
		map.add(NodeLabels.ExitCottage.toString(),getExitCottageSequence());
		map.add(NodeLabels.SpeakWithGeneralEduarttogivedecision.toString(),getSpeakWithGeneralEduartToGiveDecision());
		map.add(NodeLabels.YesToKnowingKiller.toString(),getYesToKnowingKillerSequence());
		map.add(NodeLabels.SayNoToKnowingKiller.toString(),getSayNoToKnowingKillerSequence());
		map.add(NodeLabels.ShowProof.toString(),getShowProofSequence());
		map.add(NodeLabels.NoProof.toString(),getNoProofSequence());
		map.add(NodeLabels.ShowEvidenceForRoki.toString(),getShowEvidenceForRokiSequence());
		map.add(NodeLabels.OkayFromGeneralToGoodChoice.toString(),getOkayFromGeneralToGoodChoiceSequence());
		map.add(NodeLabels.GiveWrongItemForRightChoice.toString(),getGiveWrongItemForRightChoiceSequence());
		map.add(NodeLabels.ExitCityToDungeonGoodEnding.toString(),getExitCityToDungeonGoodEndingSequence());
		map.add(NodeLabels.Promotion.toString(),getPromotionSequence());
		map.add(NodeLabels.endFade.toString(),getendFadeSequence());
		map.add(NodeLabels.ShowEvidenceForOpponentShopKeeper.toString(),getShowEvidenceForOpponentShopKeeperSequence());
		map.add(NodeLabels.GiveRightEvidenceToEduartForShopKeeper.toString(),getGiveRightEvidenceToEduartForShopKeeperSequence());
		map.add(NodeLabels.TeleportToDungeonForBadEnding.toString(),getTeleportToDungeonForBadEndingSequence());
		map.add(NodeLabels.BadEndingDialog.toString(),getBadEndingSequence());
		map.add(NodeLabels.ShowEvidenceForApprentice.toString(),getShowEvidenceForApprenticeSequence());
		map.add(NodeLabels.DialogForCorrectEvidenceForApprentice.toString(),getDialogForCorrectEvidenceForApprenticeSequence());
		return map;
	}

	@Override
	public INode getRoot() {
		// TODO Auto-generated method stub
		return new Node("root");
	}

	@Override
	public void getThings() {
		Edric = new Character(ThingNames.Tom.toString(), BodyType.C, Clothing.LightArmour, HairStyles.Short);
		Rimmons = new Character(ThingNames.Rimmons.toString(), BodyType.H, Clothing.Peasant, HairStyles.Short);
        GeneralEduart = new Character(ThingNames.GeneralEduart.toString(), BodyType.D, Clothing.HeavyArmour,HairStyles.Short);
        StarterPlace = new Place(ThingNames.Home.toString(), Place.Places.Bridge);
        CourtYard = new Place(ThingNames.CourtYard.toString(), Place.Places.Courtyard);
        Port = new Place(ThingNames.Port.toString(), Place.Places.Port);
        Tavern = new Place(ThingNames.Tavern.toString(), Place.Places.Tavern);
        Cottage1 = new Place(ThingNames.Cottage1.toString(), Place.Places.Cottage);
        Cottage2 = new Place(ThingNames.Cottage2.toString(), Place.Places.Cottage);
        Dungeon = new Place(ThingNames.Dungeon.toString(), Place.Places.Dungeon);
        City = new Place(ThingNames.City.toString(), Place.Places.City);
        AlchemyShop = new Place(ThingNames.AlchemyShop.toString(), Place.Places.AlchemyShop);
        SoldierFrye = new Character(ThingNames.SoldierFrye.toString(), BodyType.F, Clothing.HeavyArmour, HairStyles.Short);
        SoldierHale = new Character(ThingNames.SoldierHale.toString(), BodyType.H, Clothing.HeavyArmour, HairStyles.Short);
        SoldierTyre = new Character(ThingNames.SoldierTyre.toString(), BodyType.B, Clothing.HeavyArmour, HairStyles.Short);
        SoldierWinfred = new Character(ThingNames.SoldierWinfred.toString(), BodyType.F, Clothing.LightArmour, HairStyles.Short);
        SoldierStani = new Character(ThingNames.SoldierStani.toString(),BodyType.H, Clothing.LightArmour, HairStyles.Short);
        Roki = new Character(ThingNames.Roki.toString(), BodyType.B, Clothing.Bandit, HairStyles.Short);
        LadyMarina = new Character(ThingNames.LadyMarina.toString(), BodyType.C, Clothing.Priest, HairStyles.Long);
        LadyKasumi = new Character(ThingNames.LadyKasumi.toString(), BodyType.E, Clothing.Peasant, HairStyles.Ponytail);
        //SuspectHumphrey = new Character(ThingNames.SuspectHumphrey.toString());
        //CustomerAleksey = new Character(ThingNames.CustomerAleksey.toString());
        BartenderMeier = new Character(ThingNames.BartenderMeier.toString(),BodyType.B, Clothing.Merchant, HairStyles.Short);
        Soporific = new Item(ThingNames.GreenPotion.toString(), Items.GreenPotion);
        Skull = new Item(ThingNames.Skull.toString(), Items.Skull);
        Cup = new Item(ThingNames.Cup.toString(), Items.Cup);
        Ledger = new Item(ThingNames.OpenScroll.toString(), Items.OpenScroll);
        GreenPotion = new Item(ThingNames.GreenPotion.toString(), Items.GreenPotion);
        OpponentShopKeeper = new Character(ThingNames.OppopentShopKeeper.toString());
        Book = new Item(ThingNames.SpellBook.toString(), Items.SpellBook);
        Scroll = new Item(ThingNames.OpenScroll.toString(),Items.OpenScroll);
        

		
		
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Edric));
		sequence.combineWith(new CharacterCreation(GeneralEduart));
		sequence.add(new Create<Place>(StarterPlace));
		sequence.add(new Position(Edric, StarterPlace));
		sequence.add(new Position(GeneralEduart, StarterPlace, "SouthEnd"));
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
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"GeneralEduart: Greetings soldier, I have a task for you. There's been reports\n of a murder at the local alchemy shop.\n I've already sent a few men to check it out,\n and they're waiting for you to come check it out. Once you've figured out who the culprit is, you can find me at the City fountain.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	
	private ActionSequence getTeleportToShopViaGeneralSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getEnterAlchemyShopSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(SoldierHale));
		sequence.combineWith(new CharacterCreation(SoldierFrye));
		sequence.combineWith(new CharacterCreation(SoldierWinfred));
		sequence.combineWith(new CharacterCreation(LadyMarina));
		sequence.add(new Position(LadyMarina, AlchemyShop, "AlchemistTable.Center"));
		sequence.add(new Position(SoldierHale, AlchemyShop, "RightBookcase"));
		sequence.add(new Position(SoldierFrye, AlchemyShop, "Chest"));
		sequence.add(new Position(SoldierWinfred, AlchemyShop, "Cauldron"));
		sequence.add(new Position(Book, AlchemyShop, "Table.Left"));
		sequence.add(new Create<Place>(AlchemyShop));
		sequence.add(new Position(Edric, AlchemyShop));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getPickUpBookSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, Book, AlchemyShop.getFurniture("Table")));
		sequence.add(new Pocket(Edric, Book));
		return sequence;
	}
	
	private ActionSequence getAddBookToInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new AddToList(Book, "A spellbook with many unique spells. It's quite heavy."));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierHaleSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierHale));
		sequence.add(new SetDialog("\"Greets Soldier, glad you could make it. We received reports of a murder happening\n at this shop early in the morning. We tried to get here as soon as we could, but then the shopkeeper was long gone. The only known person at the shop during the time of the murder was the apprentice, but we can't rule out the possibility of others being here.\n [ideal|Do you have any idea where I could look] [lazy|Okay, I'll take a look around]\""));
		//sequence.add(new SetDialog("\"There's a lady in a nearby alleyway who claims to have spotted who ran out the shop around the time of the murder.\n I'd suggest speaking with her to get more information.\""));
		//sequence.add(new SetDialog("\"Good luck.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice2));
		//sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getIdealAnswerwithHaleSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"There's a lady in a nearby alleyway who claims to have spotted who ran out the shop around the time of the murder.\n I'd suggest speaking with her to get more information.[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getLessIdealAnswerwithHaleSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Good luck.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getContinueSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		return sequence;
			
	}
	
	
	private ActionSequence getSpeakWithSoldierWinfredSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierWinfred));
		sequence.add(new SetDialog("\"Cruel world this is. Dying in your store. I'm glad the shopkeeper's apprentice called to report the situation, but she's the only one we know of who could've done it. Ironic, isn't it? [betteroption|Is the apprentice still in the shop?] [worseoption|Indeed]\""));
		//sequence.add(new SetDialog("\"Yes, you may speak with her if you'd like. You could get some useful information from her. Between you and me, I heard she would inherit the show if he ever passed.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Another place that could be worth exploring is the cottage of another shopkeeper. He's notorious for hating this guy. There's a posibility you could find something useful there.\n [Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Well, I wish you luck on your search for information.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice3));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getBetterOptionWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Yes, you may speak with her if you'd like. You could get some useful information from her. Between you and me, I heard she would inherit the show if he ever passed.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getWorseOptionWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Well, I wish you luck on your search for information.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getContinueWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Another place that could be worth exploring is the cottage of another shopkeeper. He's notorious for hating this guy. There's a posibility you could find something useful there.\n [Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierFryeSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierFrye));
		sequence.add(new SetDialog("\"From what we can tell, the shopkeeper was killed with a blunt object, but we aren't sure what that object was.\n [GoodOption|Do you know of any places to look?] [BadOption|How are you that incompetent at your job?]\""));
		//sequence.add(new SetDialog("\"I'd suggest the tavern. The bartender knows a lot about the city. He might have information that could prove useful.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Careful now, insulting your superior is the fastest way to be fired.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice4));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodChoiceFryeSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"I'd suggest the tavern. The bartender knows a lot about the city. He might have information that could prove useful.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadChoiceFryeSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Careful now, insulting your superior is the fastest way to be fired.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyMarinaSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyMarina));
		sequence.add(new SetDialog("\"I know how this looks, but I'm innocent. I was taking a stroll through the city last night, and I wanted to ask my boss something. When I entered the shop, he was dead! You've got to figure out who did it.\n[Continue|Continue]\""));
		sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice5));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getExitAlchemyShopViaTeleportSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, AlchemyShop.getFurniture("Door"), true));
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getEnterCitySequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(LadyKasumi));
		sequence.add(new Position(LadyKasumi, City, "Alley2"));
		sequence.add(new Position(GeneralEduart, City, "Fountain"));
		sequence.add(new Create<Place>(City));
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		//sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyKasumiSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyKasumi));
		sequence.add(new SetDialog("\"Hey there, are you one of the guards investigating the murder inside the shop? [Good Option|Yes] [Bad Option|No]\""));
		//sequence.add(new SetDialog("\"Then why are you here in the alley? If you don't leave, I'll get the guards to come arrest you.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Alright, I just wanted to make sure. Early in the morning, I saw someone running from the shop to the pier. He must've been the killer. You need to go after him!\n [GoodOption|Teleport To Pier] [BadOption|I don't trust you]\""));
		//sequence.add(new SetDialog("\"WHAT! Men these days, you idiots never believe anything a woman says.\n[Continue|Continue]\""));
		//Implement Exiting City for pier option later
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice6));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodOptionKasumiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Alright, I just wanted to make sure. Early in the morning, I saw someone running from the shop to the pier. He must've been the killer. You need to go after him!\n [GoodOption|Teleport To Pier] [BadOption|I don't trust you]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionKasumiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Then why are you here in the alley? If you don't leave, I'll get the guards to come arrest you.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getTeleportToPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getSayNoToPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"WHAT! Men these days, you idiots never believe anything a woman says.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getEnterPierSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Roki));
		sequence.combineWith(new CharacterCreation(SoldierStani));
		sequence.combineWith(new CharacterCreation(SoldierTyre));
		sequence.add(new Create<Place>(Port));
		sequence.add(new Position(Edric, Port));
		sequence.add(new Position(SoldierStani, Port, "SmallStall"));
		sequence.add(new Position(SoldierTyre, Port, "BigShip"));
		sequence.add(new Position(Roki, Port, "SmallShip"));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	//Add Exit Via Guard Option Later
	private ActionSequence getSpeakWithSoliderStaniSequence() {
		var sequence = new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierStani));
		sequence.add(new SetDialog("\"Would you like to leave the pier? [Yes|Yes] [No|No]\""));
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		return sequence;
	}
	
	private ActionSequence getDoNotLeavePierYetSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Alright, just let me know when you're ready to leave.[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getExitPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getSpeakWithRokiSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(Roki));
		sequence.add(new SetDialog("\"What do you want with me, can't you see I'm busy?\n [Good Option| Why are you in such a rush] [Bad Option|Sorry Sir, I didn't notice]\""));
		sequence.add(new SetDialog("\"Yeah, idiot.\n[Continue|Continue]\""));
		sequence.add(new SetDialog("\"I'm not telling you anything. Why can't you guards just let me leave!\n[Continue|Continue]\""));
		sequence.add(new HideDialog());
		sequence.add(new DisableIcon(actionChoice6));
		sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierTyreSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierTyre));
		sequence.add(new SetDialog("\"Good Morning, is there something you wanted to ask?\n [GoodAnswer|What's going on with that frazzled guy?] [BadAnswer|Nothing, just looking around]\""));
		//sequence.add(new SetDialog("\"Okay, I'll be here if you need to ask any questions.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Oh, Roki? I'm not sure, but he seems to be in quite the hurry to leave. When he came in he seemed drunk out of his mind.\n He keeps asking us for a boat, but we can't give him something he doesn't own.\n [Interesting]\""));
		//sequence.add(new SetDialog("\"Isn't it? Well, if that'll be all, have a nice day.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice10));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	
	private ActionSequence getGoodAnswerFromTyreforfirstquestionSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Oh, Roki? I'm not sure, but he seems to be in quite the hurry to leave. When he came in he seemed drunk out of his mind.\n He keeps asking us for a boat, but we can't give him something he doesn't own.\n [I'm trying to find out who killed a local shopkeeper. Do you have an  idea who it could've been?]\""));
		return sequence;
	}
	
	private ActionSequence getNeutralAnswerFromTyreSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Okay, I'll be here if you need to ask any questions.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getFinalDialogFromTyreSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"I'm not exactly sure, but when Roki came in, he was holding a mug. Maybe it could help you out?\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getAddCupToInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Give(SoldierTyre, Cup, Edric));
		sequence.add(new Pocket(Edric, Cup));
		sequence.add(new AddToList(Cup, "A mug obtained from the local tavern. Looks damaged at the bottom"));
		return sequence;

	}

	
	
	private ActionSequence getCityToTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, City.getFurniture("GreenHouseDoor"), true));
		return sequence;
	}
	
	private ActionSequence getEnterTavernSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(BartenderMeier));
		sequence.combineWith(new CharacterCreation(Rimmons));
		sequence.add(new Create<Place>(Tavern));
		sequence.add(new Create<Item>(Cup));
		sequence.add(new Position(Cup, Tavern, "Table.front"));
		sequence.add(new Position(Rimmons, Tavern, "BackLeftStool"));
		sequence.add(new Position(BartenderMeier, Tavern, "Bar.Behind"));
		sequence.add(new Position(Edric, Tavern));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getSpeakWithRimmonsSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(Rimmons));
		sequence.add(new SetDialog("\"Uhh....hhh..hhh.. ca...n't....t sp....e..a..k.......Mu.s....tF....i....n..d...K..a...r.e...n\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice7));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithBartenderMeierSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1)); (remove these)
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(BartenderMeier));
		sequence.add(new SetDialog("\"Hi sir, what can I do for you?\n [Good Dialog|I'd like to ask about the muder that happened last night]\n [Bad Option|Give me your finest bourbon]\""));
//		sequence.add(new SetDialog("\"Sorry sir, we don't serve drinks this early. Only reason we're open is because that drunk bloat isn't able to leave. Please come back tonight.\\n[Continue|Continue]\""));
//		sequence.add(new SetDialog("\"Why do you think I'd know anything about that? [GoodChoice|I've heard you have ways of getting information.] [BadChoice|Because I'll arrest you if you don't have information]\""));
//		sequence.add(new SetDialog("\"Well, I may not know who directly caused it, but one of my patrons left this place last night particularly drunk. He always talks about how he used to be a sailor. Perhaps he might know something.\n[Continue|Continue]\""));
//		sequence.add(new SetDialog("\"Okay, I've heard enough. Get out of my shop, now!\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice8)); (remove these)
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodOptionFromMeiserSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Why do you think I'd know anything about that? [GoodChoice|I've heard you have ways of getting information.] [BadChoice|Because I'll arrest you if you don't have information]\""));
		return sequence;

	}
	
	private ActionSequence getGoodOptionFromGoodOptionFromMeiserSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Well, I may not know who directly caused it, but one of my patrons left this place last night particularly drunk. He always talks about how he used to be a sailor. Perhaps he might know something.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionFromMeiserSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Sorry sir, we don't serve drinks this early. Only reason we're open is because that drunk bloat isn't able to leave. Please come back tonight.\\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionFromGoodOptionMeiserSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Okay, I've heard enough. Get out of my shop, now!\n[Continue|Continue]\""));
		return sequence;
	}
	
	
	private ActionSequence getExitTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Tavern.getFurniture("Door"), true));
		sequence.add(new FadeOut());
		return sequence;
	}
// Expand on Cottage	
	private ActionSequence getEnterCottageSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(Cottage1));
		sequence.add(new Position(Edric, Cottage1));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new Position(GreenPotion, Cottage1, "Table"));
		sequence.add(new Position(Scroll, Cottage1, "Shelf"));
		sequence.add(new FadeIn());
		return sequence;
	}
//map actions after	
	private ActionSequence getPickUpScrollSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, Scroll));
		return sequence;

	}
	
	private ActionSequence getReadScrollSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowNarration());
		sequence.add(new SetNarration("\"Curses, my doctor told me this potion would calm my nerves, but all it does is make me crazy\n I don't know what to do anymore. I've become dependant on it. Severe pain strikes my body when I'm not under its influence.\n It's only a matter of time before I hurt someone.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getCloseandPutDownScrollSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideNarration());
		sequence.add(new PutDown(Edric, Scroll));
		return sequence;
	}
	
	private ActionSequence getPickUpPotionandAddtoInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, GreenPotion));
		sequence.add(new AddToList(GreenPotion, "\"Liquid with makes the drinker frenzied when consumed. Very addictive.\""));
		sequence.add(new Pocket(Edric, GreenPotion));
		return sequence;
	}
	
	
	private ActionSequence getExitCottageSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Cottage1.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithGeneralEduartToGiveDecision() {
		var sequence = new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"Have you figured out who killed the Shop Owner?\n[Yes|Yes] [No|No]\""));
		//sequence.add(new SetDialog("\"Then what are you doing here? Get to Work!\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Really now, who do you suppose is guilty?\n [BadOption1|Lady Marina(Apprenctice)] [Correct|Roki] [BadOption2|Rival Shopkeeper]\""));
		//sequence.add(new SetDialog("\"Before I arrest anyone, I'll need you to give me some evidence that proves their guilt. Do you have any?\n [Yes|Yes (Present Evidence)] [No|No]\""));
		//sequence.add(new SetDialog("\"Sorry, but I cannot arrest anyone without evidence. Come back when you do.\n[Continue|Continue]\""));
		//sequence.add(new ShowList(Edric));
		//sequence.add(new Give(Edric, Cup, GeneralEduart));
		//Write Description for Cup (acts as the explanation)
		//sequence.add(new SetDialog("\"This is sufficient, I'll send my men to the pier to arrest him. Thank you for your assistance.[Continue]\""));
		//sequence.add(new SetDialog("\"What? How on earth is this related to that individual? Quit wasting my time and get back to work[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getYesToKnowingKillerSequence() {
		var sequence = new ActionSequence();
		new SetDialog("\"Really now, who do you suppose is guilty?\n [BadOption1|Lady Marina(Apprenctice)] [Correct|Roki] [BadOption2|Rival Shopkeeper]\"");
		return sequence;
	}
	
	private ActionSequence getSayNoToKnowingKillerSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Then what are you doing here? Get to Work!\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getShowProofSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Before I arrest anyone, I'll need you to give me some evidence that proves their guilt. Do you have any?\n [Yes|Yes (Present Evidence)] [No|No]\""));
		return sequence;
	}
	
	private ActionSequence getNoProofSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Sorry, but I cannot arrest anyone without evidence. Come back when you do.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getShowEvidenceForRokiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Cup, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getOkayFromGeneralToGoodChoiceSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"This is sufficient, I'll send my men to the pier to arrest him. Thank you for your assistance.[Continue]\""));
		return sequence;
	}
	
	private ActionSequence getGiveWrongItemForRightChoiceSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"What? How on earth is this related to that individual? Quit wasting my time and get back to work[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getExitCityToDungeonGoodEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new Position(Roki, Dungeon, "DirtPile"));
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new Position(Edric, Dungeon));
		sequence.add(new Position(GeneralEduart, Dungeon));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getPromotionSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"Great Work Soldier, I'm glad you were able to determine the culpurit. For doing such a great job, I'm promoting you to the rank of general.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getendFadeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getShowEvidenceForOpponentShopKeeperSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, GreenPotion, GeneralEduart));
		return sequence;
	}
	
	private ActionSequence getGiveRightEvidenceToEduartForShopKeeperSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"Wow, I knew he hated the guy, but I didn't expect he could stoop so low. Alright, I'll go get the guards. Good work.\n [Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getTeleportToDungeonForBadEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new Position(Edric, Dungeon, "DirtPile"));
		sequence.add(new Position(GeneralEduart, Dungeon));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getBadEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"I cannot believe this. How could you get the wrong person! We arrested an innocent person because of your incomeptent. Not only are you fired, you will stay in the dungeon for one year as punishment.\n I hope you use this opportunity to reflect on your wrongdoings. [Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getShowEvidenceForApprenticeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Book, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getDialogForCorrectEvidenceForApprenticeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"A book to the head? I suppose that could've killed him. Alright, good work. I'll send my guards\n [Continue|Continue]\""));
		return sequence;
	}
	
	
	
	
	
	
	
	

}
