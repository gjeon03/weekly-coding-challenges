class Solution {
    fun solution(new_id: String): String {
        return new_id
            .let {
                it.lowercase()
            } // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            .let {
                it.toCharArray().filter { char ->
                    char.isLowerCase() ||
                    char.isDigit() ||
                    char == '-' ||
                    char == '_' ||
                    char == '.'
                }
            } // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            .let {
                val result = mutableListOf<Char>()
                var index = 0
                var skipFlag = false
                while(index < it.size) {
                    if(it[index] == '.' && !skipFlag) {
                        result.add(it[index])
                        skipFlag = true
                    }
                    else if(it[index] != '.') {
                        result.add(it[index])
                        skipFlag = false
                    }
                    index += 1
                }
                result
            } // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            .let {
                if(it.isEmpty()) return@let it
                if(it.size == 1 && it[0] == '.') return@let mutableListOf()
                if(it.size == 2 && it[0] == '.' && it[1] == '.') return@let mutableListOf()

                if(it.first() == '.' && it.last() == '.') {
                    it.subList(1, it.size - 1)
                } else if (it.first() == '.') {
                    it.subList(1, it.size)
                } else if (it.last() == '.') {
                    it.subList(0, it.size - 1)
                } else {
                    it
                }
            } // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            .apply {
                if(isEmpty()) add('a')
            } // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            .let {
                with(if(it.size >= 16) it.subList(0, 15) else it) {
                    if(last() == '.') subList(0, size - 1) else this
                }
            } // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            .apply {
                if(size <= 2) {
                    while(size < 3) add(last())
                }
            } // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            .joinToString("")
    }
}