# 전종설 프로젝트
## 📑 커밋 컨벤션
### 📌 Branch
- "main"에는 배포 했을 시에만(서버 연동), 모든 PR & Merge는 "develop" 에서 이루어진다.
- "yejin" 등 자신의 이름의 브랜치를 따 개인 작업 진행 -> "develop" 브랜치로 PR
- “develop” → "main" 의 Merge 작업은 한 사람이 진행한다.

### 📌 Commit message
- "[기능] 제목 - 부연설명" 형식으로 이루어진다.
- “[기능] 제목” → 필수
- "- 부연설명" → 선택
- 15자 이상 X

### 📌 [기능]
- FEAT : 새로운 기능의 추가
- ADD : 단순 코드 추가
- FIX: 버그 수정
- DOCS: 문서 수정
- STYLE: 스타일 관련 기능(코드 포맷팅, 세미콜론 누락, 코드 자체의 변경이 없는 경우)
- REFACTOR: 코드 리펙토링
- TEST: 테스트 코트, 리펙토링 테스트 코드 추가
- CHORE: 빌드 업무 수정, 패키지 매니저 수정(ex .gitignore 수정 같은 경우)