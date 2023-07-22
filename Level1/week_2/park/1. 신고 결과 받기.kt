class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportMap = mutableMapOf<String, MutableSet<String>>()
        report.forEach {
            val (reporter, reported) = it.split(" ")
            val reporters = reportMap.getOrPut(reported) { mutableSetOf() }
            reporters.add(reporter)
        }

        val notifiedMap = mutableMapOf(*id_list.map { it to 0 }.toTypedArray())
        reportMap.forEach { entry ->
            if(entry.value.size >= k) {
                entry.value.forEach {
                    notifiedMap.compute(it) { _, oldValue ->
                        if(oldValue == null) 0 else oldValue + 1
                    }
                }
            }
        }

        return id_list.mapNotNull { notifiedMap[it] }.toIntArray()
    }
}