package com.demo.basics.designpatterns._26_statemachine;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

enum ShoppingCartEvent {
    ADD_ITEM,
    MAKE_PAYMENT,
    PAYMENT_SUCESS,
    PAYMENT_FAIL,
    DISPATCHED
}

enum ShoppingCart {
    BEGIN_STATE {
        @Override
        public ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener) {
            switch (event) {
                case ADD_ITEM:
                    return SHOPPING_STATE;
                default:
                    throw new UnsupportedOperationException("Not Supported!");
            }
        }
    },
    SHOPPING_STATE {
        @Override
        public ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener) {
            switch (event) {
                case ADD_ITEM:
                    return SHOPPING_STATE;
                case MAKE_PAYMENT:
                    return PAYMENT_STATE;
                default:
                    throw new UnsupportedOperationException("Not Supported!");
            }
        }
    },
    PAYMENT_STATE {
        @Override
        public ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener) {
            switch (event) {
                case PAYMENT_SUCESS:
                    notifyListener.notifyObservers("SHIPPED_STATE: Shipped product after purchase!");
                    return SHIPPED_STATE;
                case PAYMENT_FAIL:
                    return SHOPPING_STATE;
                default:
                    throw new UnsupportedOperationException("Not Supported!");
            }
        }
    },
    SHIPPED_STATE {
        @Override
        public ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener) {
            switch (event) {
                case DISPATCHED:
                    return COMPLETED_STATE;
                default:
                    throw new UnsupportedOperationException("Not Supported!");
            }
        }
    },
    COMPLETED_STATE {
        @Override
        public ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener) {
            throw new UnsupportedOperationException("Not Supported!");
        }
    };

    public abstract ShoppingCart nextState(ShoppingCartEvent event, NotifyListener notifyListener);

}

interface Observer {
    public void notify(String message);
}

interface Subject {
    public void registerObserver(Observer observer);

    public void notifyObservers(String tick);
}

public class StateMachineTest {
    @Test
    public void test() {

        NotifyListener notifyListener = new NotifyListener();
        notifyListener.registerObserver(new ShippedEventObserver());

        ShoppingCart state = ShoppingCart.BEGIN_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.ADD_ITEM);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.ADD_ITEM, notifyListener));
        System.out.println();

        state = ShoppingCart.BEGIN_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.MAKE_PAYMENT);
        try {
            System.out.println("After State: " + state.nextState(ShoppingCartEvent.MAKE_PAYMENT, notifyListener));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        state = ShoppingCart.SHOPPING_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.ADD_ITEM);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.ADD_ITEM, notifyListener));
        System.out.println();
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.MAKE_PAYMENT);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.MAKE_PAYMENT, notifyListener));
        System.out.println();

        state = ShoppingCart.PAYMENT_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.PAYMENT_SUCESS);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.PAYMENT_SUCESS, notifyListener));
        System.out.println();
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.PAYMENT_FAIL);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.PAYMENT_FAIL, notifyListener));
        System.out.println();

        state = ShoppingCart.SHIPPED_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.DISPATCHED);
        System.out.println("After State: " + state.nextState(ShoppingCartEvent.DISPATCHED, notifyListener));
        System.out.println();

        state = ShoppingCart.COMPLETED_STATE;
        System.out.println("Current State: " + state.name());
        System.out.println("Event: " + ShoppingCartEvent.MAKE_PAYMENT);
        try {
            System.out.println("After State: " + state.nextState(ShoppingCartEvent.MAKE_PAYMENT, notifyListener));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
}

class ShippedEventObserver implements Observer {
    @Override
    public void notify(String message) {
        if (message.startsWith(ShoppingCart.SHIPPED_STATE.toString())) {
            //This observer is interested only in shipped events.
            System.out.println("ShippedEventObserver got Message: " + message);
        }
    }
}

class NotifyListener implements Subject {
    List<Observer> notifyList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        notifyList.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        notifyList.forEach(e -> e.notify(message));
    }
}
