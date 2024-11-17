import Link from "next/link"
import styles from "src/app/styles/navigation.module.css"

export default function Navigation(){
  return (
    <nav>
      <ul className={styles.navigation}>
        <Link href="/">
          <li>ITEMS</li>
        </Link>
        <Link href="/about">
          <li>ABOUT</li>
        </Link>
        <Link href="/userRegister">
          <li>サインイン</li>
        </Link>
      </ul>
    </nav>
  )
}