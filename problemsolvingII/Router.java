import java.util.*;

public class Router {
    Deque<int[]> q = new LinkedList<>();
    HashSet<String> packets = new HashSet<>();
    Map<Integer, ArrayList<Integer>> destMap = new HashMap<>();
    int lim;

    public Router(int memoryLimit) {
        lim = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "-" + destination + "-" + timestamp;
        if (packets.contains(key)) return false;

        if (q.size() >= lim) {
            forwardPacket();
        }

        int[] packet = {source, destination, timestamp};
        q.addLast(packet);
        packets.add(key);

        destMap.putIfAbsent(destination, new ArrayList<>());
        destMap.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[]{};
        int[] res = q.removeFirst();
        String key = res[0] + "-" + res[1] + "-" + res[2];
        packets.remove(key);
        destMap.get(res[1]).remove(0);
        return res;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        int l=lower_bound(startTime,destMap.get(destination));
        int r=lower_bound(endTime+1,destMap.get(destination));
        return r-l;
    }

    private int lower_bound(int limit, ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size();
        int result = arr.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= limit) {
                result = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;

    }
}
/*
class Router {
    private static final int[] NO_PACKET_OUT = {};

    private static class Packet {
        final int source;
        final Destination destination;
        final int timestamp;
        Packet next;

        Packet(int source, Destination destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public int hashCode() {
            return 63419 * destination.id + source;
        }

        @Override
        public boolean equals(Object obj) {
            Packet other = (Packet) obj;
            return source == other.source && destination == other.destination;
        }

        int[] toArray() {
            return new int[] { source, destination.id, timestamp };
        }
    }

    private static class Destination {
        final int id;
        // Circular array of packet times
        int[] times = new int[4];
        int head;
        int size;

        Destination(int id) {
            this.id = id;
        }

        void add(Packet p) {
            int n = times.length;
            if (size == n) {
                int[] times0 = times;
                times = new int[n << 1];
                n -= head;
                if (size <= n)
                    System.arraycopy(times0, head, times, 0, size);
                else {
                    System.arraycopy(times0, head, times, 0, n);
                    System.arraycopy(times0, 0, times, n, size - n);
                }
                head = 0;
                times[size++] = p.timestamp;
            } else
                times[(head + size++) % n] = p.timestamp;
        }

        void removeFirst() {
            head = (head + 1) % times.length;
            size--;
        }

        // Returns max i from given range such that times[i] <= time
        private int maxLEIndex(int left, int right, int time) {
            int[] times = this.times;
            if (time < times[left])
                return left - 1;
            if (times[right] <= time)
                return right;
            while (true) {
                int mid = (left + right) >> 1;
                if (mid == left)
                    return left;
                if (times[mid] <= time)
                    left = mid;
                else
                    right = mid;
            }
        }

        // startTime is exclusive, endTime is inclusive
        int getCount(int startTime, int endTime) {
            if (size == 0)
                return 0;
            int n = times.length;
            int tail = head + size - 1;
            int si;
            if (tail < n)
                si = maxLEIndex(head, tail, startTime);
            else {
                tail -= n;
                si = maxLEIndex(head, --n, startTime);
                if (si < n) {
                    int ei = maxLEIndex(si + 1, n, endTime);
                    return ei < n ? ei - si : maxLEIndex(0, tail, endTime) + 1 + n - si;
                } else
                    si = maxLEIndex(0, tail, startTime);
            }
            return si < tail ? maxLEIndex(si + 1, tail, endTime) - si : 0;
        }
    }

    private final Map<Integer, Destination> idToDest = new HashMap<>();
    private Set<Packet> freshPackets;
    private int lastTime;
    private int freeSpace;
    private Packet head;
    private Packet tail;

    public Router(int memoryLimit) {
        freeSpace = memoryLimit;
    }

    private Packet removeFirst() {
        Packet p = head;
        head = p.next;
        if (p.timestamp == lastTime && !freshPackets.isEmpty())
            freshPackets.remove(p);
        p.destination.removeFirst();
        freeSpace++;
        return p;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Destination dest = idToDest.computeIfAbsent(destination, Destination::new);
        Packet p = new Packet(source, dest, timestamp);
        if (timestamp > lastTime) {
            lastTime = timestamp;
            freshPackets = new HashSet<>();
        }
        if (freshPackets.add(p)) {
            if (--freeSpace < 0)
                removeFirst();
            if (head == null)
                head = tail = p;
            else
                tail = tail.next = p;
            dest.add(p);
            return true;
        } else
            return false;
    }

    public int[] forwardPacket() {
        return head != null ? removeFirst().toArray() : NO_PACKET_OUT;
    }

    public int getCount(int destination, int startTime, int endTime) {
        Destination dest = idToDest.get(destination);
        return dest != null ? dest.getCount(startTime - 1, endTime) : 0;
    }
}
 */
