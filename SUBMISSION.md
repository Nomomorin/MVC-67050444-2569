\# SUBMISSION - Exit Exam MVC 1/2569 (อาทิตย์เช้า)



\## 1. วิธีเปิดโปรแกรม

\- ภาษา/เฟรมเวิร์ก: Java, Console Application

\- Entry point / คำสั่งเปิดโปรแกรม: src/app/Main.java

\- หมายเหตุที่จำเป็น (ถ้ามี): โปรแกรมใช้ข้อมูลตั้งต้นจาก DataSeeder และทำงานผ่าน Console โดยสถานะข้อมูลจะอยู่ระหว่างการรันโปรแกรมเท่านั้น



\## 2. ตารางเชื่อมโยง Requirements



| Requirement | Model / Domain | Controller / Action | View / Screen |

|---|---|---|---|

| R1 | `Election`, `Ballot`, `Candidate`, `Voter`, `Officer` | `ApplicationController`, `ElectionController`, `BallotController`, `CandidateController`, `VoterController` | `MainView`, `SelectView`, `ElectionView`, `CandidateView`, `VoterView` |

| R2 | `Ballot`, `Voter`, `Candidate`, `Election` | `BallotController.createBallot()`, `BallotController.isHaveBallot()`, `VoterController.isActive()`, `ElectionController.electioIsOpen()` | Voter flow ใน `MainView` |

| R3 | `Ballot`, `BallotStatus`, `Election` | `ElectionController.closeElection()`, `BallotController.CheckBallot()`, `BallotController.calculateScore()` | Officer - Close Election |

| R4 | `Ballot`, `BallotStatus` | `BallotController.getPendingGroups()`, `BallotController.reviewPendingGroup()` | Officer - Review Pending Group |

| R5 | `Election`, `Ballot` | `getElectionByID()`, `getBallots()`, `calculateScore()`, `getPendingGroups()` | Officer - View Status / Close Election / Review Pending Group |



\## 3. ผลการทดสอบ



| กรณี | ผ่าน/ไม่ผ่าน | หมายเหตุ (เฉพาะที่จำเป็น) |

|---|---|---|

| T1 |  |  |

| T2 |  |  |

| T3 | |  |

| T4 |  |  |

| T5 |  |  |

| T6 |  |  |



\## 4. ความแตกต่างระหว่างแบบที่ออกกับโปรแกรมจริง (ถ้ามี)

ระบุไม่เกิน 3 ข้อ





\## 5. บันทึกการใช้ Generative AI



| เวลาโดยประมาณ | เครื่องมือ | ใช้เพื่ออะไร | นำคำแนะนำไปใช้อย่างไร |

|---|---|---|---|

##### | 09:30-09:40 | ChatGPT | ขอคำอธิบายโจทย์ |  |

| 09:40-10:00 | ChatGPT | ขอคำอธิบาย syntax Java เช่น continue, การวน List, Map, |

| 12:00-12:10 | ChatGPT | ขอ review/debug โค้ดจาก GitHub | เพื่อไปแก้ตรวจและแก้โค้ด |

