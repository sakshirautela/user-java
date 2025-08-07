interface ICharacter {
    public String getAbilities();
}

abstract class Decorator implements ICharacter {
    protected ICharacter ch;

    Decorator(ICharacter ch) {
        this.ch = ch;
    }
}

class Player implements ICharacter {
    @Override
    public String getAbilities() {
        return "I am PLayer ";
    }
}

class HeightUpDeco extends Decorator {
    public HeightUpDeco(ICharacter c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities()+" with hanging-up ";
    }
}
class GunShooterDeco extends Decorator {
    public GunShooterDeco(ICharacter c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities()+" with gunshoot";
    }
}
class StartJumpingDeco extends Decorator {
    public StartJumpingDeco(ICharacter c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities()+" with jumping";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        ICharacter p=new Player();
        System.out.println(p.getAbilities());
        p=new HeightUpDeco(p);
        System.out.println(p.getAbilities());
        p=new StartJumpingDeco(p);
        System.out.println(p.getAbilities());
        p=new GunShooterDeco(p);
        System.out.println(p.getAbilities());
        p=new GunShooterDeco(p);
        System.out.println(p.getAbilities());
    }
}
