public class EllysPairing {
	public int getMax(int M, int[] count, int[] first, int[] mult, int[] add) {
		int N = count.length ;
		int occurance = 1 ;
		int majority = -1 ;
		for (int i = 0 ; i < N ; i ++) {
			int previous = first [i] ;
			if (previous == majority)
				occurance ++ ;
			else
				occurance -- ;
			if (occurance == 0) {
				majority = previous ;
				occurance = 1 ;
			}
			for (int j = 1 ; j < count [i] ; j ++) {
				previous = (int)((1L * previous * mult[i] + add[i]) & (M - 1)) ;
				if (previous == majority)
					occurance ++ ;
				else
					occurance -- ;
				if (occurance == 0) {
					majority = previous ;
					occurance = 1 ;
				}
			}
		}

		occurance = 0 ;
		int total = 0 ;
		for (int i = 0 ; i < N ; i ++) {
			int previous = first [i] ;
			if (majority == previous)
				occurance ++ ;
			total ++ ;
			for (int j = 1 ; j < count [i] ; j ++) {
				previous = (int)((1L * previous * mult[i] + add[i]) & (M - 1)) ;
				if (majority == previous)
					occurance ++ ;
				total ++ ;
			}
		}

		if ((total & 1) == 1) {
			occurance--;
			total--;
		}

		if (occurance < total / 2) return total / 2 ;
		int bad = occurance - total / 2 ;
		return total / 2 - bad ;
	}
}