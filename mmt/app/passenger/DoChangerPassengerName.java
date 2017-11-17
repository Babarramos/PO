package mmt.app.passenger;

import mmt.core.TicketOffice;
import mmt.app.exceptions.BadPassengerNameException;
import mmt.app.exceptions.DuplicatePassengerNameException;
import mmt.app.exceptions.NoSuchPassengerException;
import mmt.core.exceptions.InvalidPassengerNameException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NonUniquePassengerNameException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import mmt.core.Passenger;

/**
 * §3.3.4. Change passenger name.
 */
public class DoChangerPassengerName extends Command<TicketOffice> {

  private TicketOffice _office;
  Input<Integer> id;
  Input<String> newname;
  
  /**
   * @param receiver
   */
  public DoChangerPassengerName(TicketOffice receiver) {
    super(Label.CHANGE_PASSENGER_NAME, receiver);

    _office = receiver;

    id = _form.addIntegerInput("id: ");
    newname = _form.addStringInput("novo nome: ");
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();

    if(id.value() >= _office.getPassengers().size()) {

      NoSuchPassengerException e = new NoSuchPassengerException(id.value());
      _display.addLine(e.getMessage());
      _display.display();

    }

    else
      _office.getPassengers().get(id.value()).setName(newname.toString());

  }
}
