package be.technifutur.labofinal.other;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.*;
import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;
    private final JobRepository jobRepository;
    private final SubclassRepository subclassRepository;
    private final ScenarioRepository scenarioRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, CharacterRepository characterRepository, JobRepository jobRepository, SubclassRepository subclassRepository, ScenarioRepository scenarioRepository) {
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
        this.jobRepository = jobRepository;
        this.subclassRepository = subclassRepository;
        this.scenarioRepository = scenarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setName("Pitou");
        user1.setPassword("Test1234=");
        user1.setStatus(Set.of(Status.GAME_MASTER));
        user1.setRoles(Set.of(Role.ADMIN));
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Blabla");
        user2.setPassword("Test1234=");
        user2.setStatus(Set.of(Status.PLAYER));
        user2.setRoles(Set.of(Role.USER));
        userRepository.save(user2);

        Job job1 = new Job();
        job1.setName("Guerrier");
        job1.setDescription("Chevaliers menant une quête, seigneurs conquérants, champions royaux, fantassins d’élite, mercenaires endurcis et rois-bandits, tous partagent une maîtrise inégalée des armes et des armures ainsi qu’une connaissance approfondie des compétences de combat. Tous côtoient la mort, l’infligeant autant qu’ils y font face.");
        job1.setHpDiceValue(10);
        job1.setMagicAvailable(false);
        jobRepository.save(job1);

        Subclass subclassGuerrier1 = new Subclass();
        subclassGuerrier1.setName("Champion");
        subclassGuerrier1.setDescription("L'archétype du champion se concentre sur le développement du pouvoir physique brut pour parvenir à la perfection mortelle. Ceux qui se basent sur cet archétype combinent une formation rigoureuse et une excellence physique pour porter des coups dévastateurs.");
        subclassGuerrier1.setJob(jobRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Job.class)));
        subclassGuerrier1.setMagicAvailable(false);
        subclassRepository.save(subclassGuerrier1);

        Subclass subclassGuerrier2 = new Subclass();
        subclassGuerrier2.setName("Maître de guerre");
        subclassGuerrier2.setDescription("Vous êtes un expert des manœuvres durant la bataille. Vous comptez sur la ruse et la prouesse pour vaincre vos ennemis. Une formation intense combinée à une attention constante vous propulse au combat. La victoire est un signe de plus de la suprématie martiale.");
        subclassGuerrier2.setJob(jobRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Job.class)));
        subclassGuerrier2.setMagicAvailable(false);
        subclassRepository.save(subclassGuerrier2);

        Subclass subclassGuerrier3 = new Subclass();
        subclassGuerrier3.setName("Chevalier occulte");
        subclassGuerrier3.setDescription("L’archétype chevalier occulte combine la maîtrise martiale commune à tous les combattants avec une étude attentive de la magie. Les chevaliers occultes utilisent des techniques magiques similaires à celles pratiquées par les magiciens, et concentrent leurs études sur deux des huit écoles de magie : abjuration et évocation. Les sorts d’abjuration accordent une protection supplémentaire au chevalier occulte dans la bataille, et les sorts d'évocation infligent des dégâts à plusieurs ennemis à la fois, augmentant la portée du guerrier en combat. Ces chevaliers apprennent un nombre relativement restreint de sorts, ce qui leur permet de les mémoriser au lieu de les garder dans un grimoire.");
        subclassGuerrier3.setJob(jobRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Job.class)));
        subclassGuerrier3.setMagicAvailable(true);
        subclassRepository.save(subclassGuerrier3);

        Job job2 = new Job();
        job2.setName("Magicien");
        job2.setDescription("Les magiciens sont de puissants utilisateurs de magie, définis et unifiés en une classe par les sorts qu’ils lancent. En utilisant des ondes magiques qui voyagent à travers l’univers, les magiciens lancent des sorts tels que des flammes explosives, des arcs de foudre, des illusions trompeuses et le contrôle de l’esprit. Leur magie peut invoquer des monstres d’autres plans d’existence, entrevoir le futur ou transformer des ennemis en zombies. Leurs sorts les plus puissants peuvent transformer une substance en une autre, faire tomber des météores du ciel et même ouvrir des portails vers d’autres mondes.");
        job1.setHpDiceValue(6);
        job2.setMagicAvailable(true);
        jobRepository.save(job2);

        Subclass subclassMagicien1 = new Subclass();
        subclassMagicien1.setName("École d'évocation");
        subclassMagicien1.setDescription("Vous concentrez vos études sur la magie qui crée des effets élémentaires puissants telles qu'un froid glacial, une flamme brûlante, un roulement de tonnerre, une foudre qui crépite ou bien encore de l'acide brûlant. Certains évocateurs se font employer par les forces militaires, servant d'artillerie pour faire sauter les armées ennemies de loin. D'autres utilisent leurs pouvoirs spectaculaires pour protéger les faibles, tandis que d'autres servent leur propre intérêt comme des bandits, des aventuriers ou des tyrans en herbe.");
        subclassMagicien1.setJob(jobRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException(2L, Job.class)));
        subclassMagicien1.setMagicAvailable(true);
        subclassRepository.save(subclassMagicien1);

        Subclass subclassMagicien2 = new Subclass();
        subclassMagicien2.setName("École d'illusion");
        subclassMagicien2.setDescription("Vous concentrez vos études sur la magie qui éblouit les sens, embrouille l'esprit et trompe même les plus sages. Votre magie est subtile, mais les illusions fabriquées par votre esprit vif rend réel ce qui semble impossible. Quelques illusionnistes, dont de nombreux gnomes magiciens, sont de petits filous qui n'utilisent leurs sorts que pour divertir. D'autres sont les plus sinistres maîtres de la tromperie, utilisant leurs illusions pour effrayer et tromper les autres afin d'obtenir un gain personnel.");
        subclassMagicien2.setJob(jobRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException(2L, Job.class)));
        subclassMagicien2.setMagicAvailable(true);
        subclassRepository.save(subclassMagicien2);

        Subclass subclassMagicien3 = new Subclass();
        subclassMagicien3.setName("École de nécromancie");
        subclassMagicien3.setDescription("L'école de nécromancie explore les forces cosmiques de la vie, de la mort et de la non-vie. Si vous concentrez vos études sur cette tradition, vous apprendrez à manipuler l'énergie qui anime tous les êtres vivants. Plus tard, vous apprendrez même à détruire le corps d’une créature en absorbant sa force de vie, transformant l’énergie vitale en pouvoir magique que vous pouvez manipuler. La plupart des personnes voient des nécromanciens comme des personnes menaçantes, voire même infâmes, en raison de leur association avec le thème de la mort. Mais tous les nécromanciens ne sont pas mauvais, même si les forces qu'ils manipulent sont considérées comme tabou par beaucoup de sociétés.");
        subclassMagicien3.setJob(jobRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException(2L, Job.class)));
        subclassMagicien3.setMagicAvailable(true);
        subclassRepository.save(subclassMagicien3);

        Job job3 = new Job();
        job3.setName("Roublard");
        job3.setDescription("Les roublards comptent sur les compétences, la furtivité et les faiblesses de l’ennemi pour contrôler n’importe quelle situation. Ils ont le don de trouver des solutions à n’importe quel problème, démontrant l’ingéniosité et la polyvalence qui sont les pierres angulaires de toute aventure réussie.");
        job3.setHpDiceValue(8);
        job3.setMagicAvailable(false);
        jobRepository.save(job3);

        Subclass subclassRoublard1 = new Subclass();
        subclassRoublard1.setName("Assassin");
        subclassRoublard1.setDescription("Vous focalisez votre entrainement sur l'art de l'assassinat. Divers personnages choisissent cet archétype : tueurs sous contrat, espions, chasseurs de primes, et même certains religieux entraînés à cela pour exterminer les ennemis de leur divinité. Discrétion, poisons et déguisements vous aident à éliminer vos cibles avec une efficacité meurtrière.");
        subclassRoublard1.setJob(jobRepository.findById(3L).orElseThrow(() -> new ResourceNotFoundException(3L, Job.class)));
        subclassRoublard1.setMagicAvailable(false);
        subclassRepository.save(subclassRoublard1);

        Subclass subclassRoublard2 = new Subclass();
        subclassRoublard2.setName("Voleur");
        subclassRoublard2.setDescription("Vous perfectionnez vos compétences dans les arts du larcin. Cambrioleurs, bandits, coupe-bourses et autres criminels suivent généralement cet archétype, de même que les roublards qui se considèrent eux-mêmes comme des chercheurs de trésors professionnels, des explorateurs ou des investigateurs. En plus d'améliorer votre agilité et votre furtivité, vous apprenez des compétences utiles pour pénétrer dans des ruines antiques, lire des langues inconnues ou utiliser des objets magiques que vous ne pourriez normalement pas employer.");
        subclassRoublard2.setJob(jobRepository.findById(3L).orElseThrow(() -> new ResourceNotFoundException(3L, Job.class)));
        subclassRoublard2.setMagicAvailable(false);
        subclassRepository.save(subclassRoublard2);

        Subclass subclassRoublard3 = new Subclass();
        subclassRoublard3.setName("Escroc arcanique");
        subclassRoublard3.setDescription("Quelques roublards améliorent leurs compétences aiguisées en furtivité et agilité avec la magie, apprenant des tours d'enchantement et d'illusion. On trouve parmi eux des voleurs à la tire et des cambrioleurs, mais aussi des farceurs, des fauteurs de troubles et un nombre important d'aventuriers.");
        subclassRoublard3.setJob(jobRepository.findById(3L).orElseThrow(() -> new ResourceNotFoundException(3L, Job.class)));
        subclassRoublard3.setMagicAvailable(true);
        subclassRepository.save(subclassRoublard3);

        Scenario scenario1 = new Scenario();
        scenario1.setName("Les îles élémentaires");
        scenario1.setSynopsis("Dans un univers divisé en plusieurs archipels indépendants suite à un cataclysme magique sans précedent survenu il y a des siècles, la longévité des elfes et autres races à longue espérance de vie ont drastiquement diminué et les druides sont devenus les garants de l'ordre établi. Dans ce contexte, un groupe d'aventuriers de l'archipel du vent se retrouve confrontré à des dangers insidieux");
        scenarioRepository.save(scenario1);

        Character character1 = new Character();
        character1.setName("Albior");
        character1.setLevel(1);
        character1.setJob(jobRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Job.class)));
        character1.setSubclass(subclassRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Subclass.class)));
        character1.setHp(14);
        character1.setStrength(18);
        character1.setDexterity(12);
        character1.setConstitution(18);
        character1.setIntelligence(12);
        character1.setWisdom(14);
        character1.setCharisma(14);
        character1.setPlayer(userRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Character.class)));
        character1.setScenario(scenarioRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(1L, Scenario.class)));
        characterRepository.save(character1);
    }
}
