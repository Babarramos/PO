package mmt.app.passenger;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.app.exceptions.NoSuchPassengerException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

import mmt.core.Passenger;

/**
 * §3.3.2. Show specific passenger.
 */
public class DoShowPassengerById extends Command<TicketOffice> {

  private TicketOffice _office;
  private Input<Integer> id;
  /**
   * @param receiver
   */
  public DoShowPassengerById(TicketOffice receiver) {
    super(Label.SHOW_PASSENGER_BY_ID, receiver);

    _office = receiver;
    id = _form.addIntegerInput("ID do passageiro: ");
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {

    _form.parse();

    if(id.value() >= _office.getPassengers().size()) {

      NoSuchPassengerException e = new NoSuchPassengerException(id.value());
      _display.addLine(e.getMessage());

    }

    else
      _display.addLine(_office.getPassengers().get(id.value()).toText());

    _display.display();

  }

}
