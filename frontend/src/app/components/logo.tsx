import styles from "src/app/styles/logo.module.css"
import Link from "next/link"

type LogProps = {
  small?:boolean;
}
export default function Logo({small = false}:LogProps){
  return (
    <>
      <Link href={"/"}>
        <h1 className={small ? styles.logoSmall: styles.logo}>YABUHANA</h1>
      </Link>
    </>
  )
}