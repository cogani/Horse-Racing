# Horse-Racing

To highlith:
 * hr.game,  hr.results: Separation between game and displaying of the results. Game and all their components are not responsable of display any result. This task is delegated to componentes inside the pakage hr.results 
 * SRP: Each component has to have only one responsability. This's valid for class and methods
 * Clean code (following guides by Uncle Bob)
 * Injection dependency: every relation has be code by injection dependency. This way allowed improve uncoupling and make easer testing process
 * Value objects: Toss, ResultItem, Score: This objects don't need any modification of their creation. Coding as value object, everything has a better state control, and the same time is easier to test (Not needing to test the transition beteween states)
 * Exception: In order to improve the semantic, every object needing to send any error, has related to this own Exception type. I prefer this approach to the generic exception one, because this approach improve the semantic. Also, I prefer throw execptions at same level of the class is throwing the error: for instance it's very weird is Race throws exception like IllegalArgumentException, and I think is more convenient RaceException (same level Class-Exception)
 * - Circuit.holeValues: I decided not injected this values via Circuit constructor because with the current requirements the holes values are always the same
 
 
 To improve
  * Using Mockito in order to test Race: with the current testing approach, RaceTesting is fact 'integration test' not unit. I couldn't use Mockito cause I didn't have time enough to setup gradle to use it. This is my first time I use gradle. I use normally Maven
  
  
  Please, any sugerence or doubt, don't hesitate to contact me.
