package story.constants;

import story.sys.Time;

public enum Mood {
    GLAD {
        @Override
        public String emote() {
            return "захохотал";
        }
    },
    ANGRY {
        @Override
        public String emote() {
            return "злится";
        }
    },
    HAPPY {
        @Override
        public String emote() {
            return "стал счастлив";
        }
    },
    SAD {
        @Override
        public String emote() {
            return "загрустил";
        }
    };

    abstract public String emote();

    @Override
    public String toString() {
        return this.name();
    }
    // hashCode нельзя переопределеить - final
    // equals нельзя переопределеить - final
}
